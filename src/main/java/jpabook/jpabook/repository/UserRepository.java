package jpabook.jpabook.repository;

import jpabook.jpabook.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Member,Long> {

    Member findByName(String name);

}
