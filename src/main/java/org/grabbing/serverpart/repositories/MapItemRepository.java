package org.grabbing.serverpart.repositories;

import org.grabbing.serverpart.dto.MapItemDto;
import org.grabbing.serverpart.entities.MapItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import java.util.List;

@Repository
public interface MapItemRepository extends JpaRepository<MapItem, Long> {
    @Query(value = "insert into grabbing.map_item select nextval('grabbing.map_item_id_seq'), :object_id, :key, :value", nativeQuery = true)
    void create(@Param("object_id") Long objectId, @Param("key") String key, @Param("value") String value);

    @Query(value = "select a.map_key as first, a.map_value as second from grabbing.map_item a where a.object_id = :object_id", nativeQuery = true)
    List<MapItemDto> getAllByObjectId(@Param("object_id") Long objectId);
}
