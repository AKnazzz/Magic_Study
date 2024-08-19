import ICommentService;
import Comment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentService implements ICommentService {
    private final Map<String, List<Comment>> articleComments = new HashMap<>();

    @Override
    public boolean addComment(String articleId, Comment comment) {
        return articleComments.computeIfAbsent(articleId, k -> new ArrayList<>()).add(comment);
    }

    @Override
    public List<Comment> getComments(String articleId) {
        return articleComments.getOrDefault(articleId, new ArrayList<>());
    }
}
