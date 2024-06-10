package module4.ex.repository;

import module4.ex.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User,Integer>, JpaRepository<User,Integer> {
        @Query("select u from User u where u.fullName like concat('%',:name,'%')")
        List<User> findAccountsByFullNameContains(String name);
    @Query("select u from User u where u.username=:username")

    User findUserByUsername(String username);
    @Query("select u from User u where u.email=:email")

    User findUserByEmail(String email);
    @Query("select u from User u where u.phone=:phone")

    User findUserByPhoneNumber(String phone);
}
