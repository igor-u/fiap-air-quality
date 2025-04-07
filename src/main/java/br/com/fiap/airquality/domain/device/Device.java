package br.com.fiap.airquality.domain.device;

import br.com.fiap.airquality.domain.UuidIdentifiedEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "devices")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public abstract class Device extends UuidIdentifiedEntity {

    private String model;

    private DeviceStatus status;

}