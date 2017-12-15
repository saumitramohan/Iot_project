



/*
 *  This sketch sends data via HTTP GET requests to data.sparkfun.com service.
 *
 *  You need to get streamId and privateKey at data.sparkfun.com and paste them
 *  below. Or just customize this script to talk to other HTTP servers.
 *
 */

#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>
#include <SoftwareSerial.h>
SoftwareSerial mySerial(12, 13); // RX, TX


const char* ssid     = "Saumi";
const char* password = "saumizero305";
HTTPClient httpClient;
float pulseRate;
float spo2;
float temperature;


String deviceId = "device2";

String endPoint = "http://ec2-54-153-51-19.us-west-1.compute.amazonaws.com:8080";

String prepareRequestUrl(float pulseRate, float temperature, float spo2){
  return endPoint + '/' + "device" + '/' + deviceId + '/' + "metric" + '/' + "pulserate/" + pulseRate + "/temperature/" + temperature + "/spo2/" + spo2 + "/";
};
 
void setup() {
  Serial.begin(115200);
  delay(10);
  // We start by connecting to a WiFi network

  Serial.println();
  Serial.println();
  Serial.print("Connecting to ");
  Serial.println(ssid);
  
  WiFi.begin(ssid, password);
  
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }

  Serial.println("");
  Serial.println("WiFi connected");  
  Serial.println("IP address: ");
  Serial.println(WiFi.localIP());

  Serial.println("Sparkfun receiving");
  // set the data rate for the SoftwareSerial port
  mySerial.begin(9600);
}

int value = 0;

void loop() {
  
  bool isAvailable;
  isAvailable = mySerial.available();
  
  if (isAvailable) {
    char* buffer  = (char*) malloc(100);
    Serial.println("Received:-");
    mySerial.readBytes(buffer,12);
    memcpy(&pulseRate,buffer, sizeof(float)) ;
    memcpy(&spo2,(char*)buffer + sizeof(float), sizeof(float)) ;
    memcpy(&temperature,(char*)buffer + 2*sizeof(float), sizeof(float)) ;
    free(buffer);
  } else {
    Serial.println("Serial not available");
    }
  String url = prepareRequestUrl(pulseRate, spo2, temperature);
  Serial.println("making request: ");
  Serial.print(url);
  httpClient.begin(url);
  int val = httpClient.sendRequest("PUT");
  Serial.println("Value");
  Serial.println(val);
  Serial.println(httpClient.getString());
  delay(2000);
}


