package org.hibernate.lazyload.repository;

import org.hibernate.lazyload.domain.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCommentRepository extends JpaRepository<PostComment, Long> {

}
