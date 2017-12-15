package sample.data.jpa.service;

import sample.data.jpa.domain.Metrics;
import org.springframework.data.repository.*;



// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface MetricsRepository extends CrudRepository<Metrics, Long> {

    public Iterable <Metrics> findTop50ByMetricTypeOrderByEntryTimeStampDesc(int value);
    public Iterable<Metrics> findTop3ByDeviceidOrderByEntryTimeStampDesc(String value);
    public Iterable<Metrics> findTop1000ByMetricTypeOrderByEntryTimeStampDesc(int value);

}