package org.hibernate.lazyload.repository;

import org.hibernate.lazyload.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
