/*
Arduino-MAX30100 oximetry / heart rate integrated sensor library
Copyright (C) 2016  OXullo Intersecans <x@brainrapers.org>

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/


#include <Wire.h>
#include "MAX30100.h"
#include "MAX30100_PulseOximeter.h"
#include <SoftwareSerial.h>
#define REPORTING_PERIOD_MS 800
PulseOximeter pox;
float temp;
SoftwareSerial mySerial(12, 13); // RX, TX

MAX30100 maxObject;
uint32_t tsLastReport = 0;


void onBeatDetected(){
    Serial.println("Beat detected");
}

void setup()
{   Serial.println("Arduino Sending");  
    Serial.begin(115200);
    if (!pox.begin(PULSEOXIMETER_DEBUGGINGMODE_PULSEDETECT)) {
        Serial.println("ERROR: Failed to initialize pulse oximeter");
        for(;;);
    }
    pox.setOnBeatDetectedCallback(onBeatDetected);
     // set the data rate for the SoftwareSerial port
    mySerial.begin(9600);
}

void loop()
{
    void* buffer = (void*) malloc(100);
    char* cursor = (char*) buffer;
    pox.update();
    // For both, a value of 0 means "invalid"
    if (millis() - tsLastReport > REPORTING_PERIOD_MS) {
        maxObject.startTemperatureSampling();
          Serial.println("-----------------------");
          Serial.print("Heart Beat:");
          Serial.println(pox.getHeartRate());
          float hr = pox.getHeartRate();
          memcpy(cursor,&hr,sizeof(float));
          cursor = cursor + sizeof(float);
          
          Serial.print("SPO2:");
          Serial.println(pox.getSpO2());
          float spo2 = pox.getSpO2();
          memcpy(cursor,& spo2,sizeof(float));
          cursor = cursor + sizeof(float);

          if(maxObject.isTemperatureReady()){
                   temp = maxObject.retrieveTemperature() * 9/5 + 32;
        }   
         Serial.print("Temperature:");
         Serial.println(temp);    
         memcpy(cursor,&temp,sizeof(float));
        tsLastReport = millis();


        //

      bool isAvailable = mySerial.available();
      Serial.println("isAvailable");
      Serial.println(isAvailable);
     if (isAvailable) {
         mySerial.write((char*)buffer);
         Serial.println("Sent data to sparkfun");
     } else {
         Serial.println("RX TX not configure");
    }
        
    }

        free(buffer);

    
    
}
