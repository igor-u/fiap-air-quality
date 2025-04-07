package br.com.fiap.airquality.domain;

import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UuidIdentifiedEntityEventListener extends AbstractMongoEventListener<UuidIdentifiedEntity> {

    @Override
    public void onBeforeConvert(@NonNull BeforeConvertEvent<UuidIdentifiedEntity> event) {

        super.onBeforeConvert(event);
        UuidIdentifiedEntity entity = event.getSource();

        if (entity.getId() == null) {
            entity.setId(UUID.randomUUID());
        }
    }

}
