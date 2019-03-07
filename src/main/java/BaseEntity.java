import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

//Базовый класс для присвоения ID
// Используется как базовый класс для всех объектов, нуждающихся в нем

@MappedSuperclass
public class BaseEntity {
    @Id
    @GenericGenerator(name = "uuid-gen", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "uuid0gen")
    @Type(type = "pg-uuid")
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public boolean isNew() {
        return (this.id == null);
    }
}
