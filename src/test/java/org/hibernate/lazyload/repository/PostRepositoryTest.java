package org.hibernate.lazyload.repository;

import java.util.Optional;

import org.hibernate.lazyload.domain.Post;
import org.hibernate.lazyload.domain.PostComment;
import org.hibernate.lazyload.domain.PostDetail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @BeforeEach
    void init() {
        Post post = new Post();
        post.setContent("test jpa lazy load");
        post.setTitle("hibernate lazy load");

        PostDetail postDetail = new PostDetail();
        postDetail.setDescription("description");

        post.addPostDetail(postDetail);

        PostComment postComment = new PostComment();
        postComment.setEmail("example@example.org");
        postComment.setContent("comment post");

        post.addPostComments(postComment);

        postRepository.save(post);
    }

    @Test
    void testFindOne() {
        Optional<Post> optionalPost = postRepository.findById(1L);
        Post post = optionalPost.get();

        System.out.println(post);
        System.out.println(post.getPostComments());
        System.out.println(post.getPostDetail());
    }
}