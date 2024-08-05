package com.riwi.persistence.crud;

public interface ReadByIdModel<Id, Entity> {
    public Entity readByID(Id id);
}
