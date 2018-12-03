package org.hibernate.lazyload.repository;

import org.hibernate.lazyload.domain.PostDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostDetailRepository extends JpaRepository<PostDetail, Long> {

}
