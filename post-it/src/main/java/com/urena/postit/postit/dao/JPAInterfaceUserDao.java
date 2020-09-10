package com.urena.postit.postit.dao;

import com.urena.postit.postit.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAInterfaceUserDao extends JpaRepository<User, Integer> {
}
