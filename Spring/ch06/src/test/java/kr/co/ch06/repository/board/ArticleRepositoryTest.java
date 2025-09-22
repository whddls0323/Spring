package kr.co.ch06.repository.board;

import jakarta.transaction.Transactional;
import kr.co.ch06.entity.board.Article;
import kr.co.ch06.entity.board.Comment;
import kr.co.ch06.entity.board.File;
import kr.co.ch06.entity.board.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ArticleRepositoryTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FileRepository fileRepository;

    @Test
    void insertUserTest() {
        User user = User.builder()
                .userid("a101")
                .name("김유신")
                .age(23)
                .build();

        userRepository.save(user);
    }

    @Test
    void insertTest() {
        User user = User.builder()
                .userid("a101")
                .build();

        Article article = Article.builder()
                                 .title("제목1")
                                 .content("내용1")
                                 .user(user)
                                 .build();

        articleRepository.save(article);
    }

    @Test
    void insertFileTest() {
        File file = File.builder()
                .oName("매출자료1.xls")
                .sName("akfal-asd-12kldf1.xls")
                .build();

        fileRepository.save(file);
    }

    @Test
    void insertCommentTest() {
        Article article = Article.builder()
                                 .ano(1)
                                 .build();

        Comment comment = Comment.builder()
                                 .content("댓글1")
                                 .author("a101")
                                 .article(article)
                                 .build();

        commentRepository.save(comment);
    }

    @Test
    @Transactional
    void selectArticleAllTest() {
        List<Article> articleList = articleRepository.findAll();
        System.out.println(articleList);

        for(Article article : articleList) {
            for(Comment comment : article.getCommentList()) {
                System.out.println(comment);
            }
        }
    }

    @Test
    @Transactional //Transactional 처리, 엔티티 연관관계에서 한번이상의 SQL처리가 이루어 지기 때문에 단일 작업처리를 위해 트랜젝션 처리, 안하면 no session 에러
    void selectArticle() {
        Optional<Article> optArticle = articleRepository.findById(1);
        System.out.println(optArticle);

        if(optArticle.isPresent()) {
            Article article = optArticle.get();
            List<Comment> commentList = article.getCommentList();

            for(Comment comment : commentList) {
                System.out.println(comment);
            }

            List<File> fileList = article.getFileList();
            for(File file : fileList) {
                System.out.println(file);
            }
        }
    }
}