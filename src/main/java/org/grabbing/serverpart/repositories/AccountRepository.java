package org.grabbing.serverpart.repositories;

import org.grabbing.serverpart.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query(value = "select count(*) from grabbing.register(:username, :password)", nativeQuery = true)
    void register(@Param("username") String username, @Param("password") String password);

    @Query(value = "select grabbing.check_existence(:username)", nativeQuery = true)
    Boolean checkExistence(@Param("username") String username);

    /*@Query("select grabbing.has_face(:username)")
    Boolean hasFace(@Param("username") String username);*/

    @Query(value = "select grabbing.attach_face(:username, :face_id)", nativeQuery = true)
    Boolean attachFace(@Param("username") String username, @Param("face_id") Long id);

    @Query(value = "select grabbing.detach_face(:username, :face_id)", nativeQuery = true)
    Boolean detachFace(@Param("username") String username, @Param("face_id") Long id);

    @Query(value = "select a.username from grabbing.account a where a.face_id = :face_id", nativeQuery = true)
    List<String> getAllByFaceId(@Param("face_id") Long faceId);

    @Query(value = "select a.face_id from grabbing.account a where a.username = :username", nativeQuery = true)
    Long getFaceIdByUsername(@Param("username") String username);
}
