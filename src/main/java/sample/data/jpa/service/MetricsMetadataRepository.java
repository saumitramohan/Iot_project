package sample.data.jpa.service;

import org.springframework.data.repository.CrudRepository;
import sample.data.jpa.domain.MetricsMetadata;

public interface MetricsMetadataRepository extends CrudRepository<MetricsMetadata, Long> {
    MetricsMetadata findAllByDescription(String desc);
}
