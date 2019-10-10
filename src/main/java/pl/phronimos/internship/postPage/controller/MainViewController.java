package pl.phronimos.internship.postPage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.phronimos.internship.postPage.entity.CommentEntity;
import pl.phronimos.internship.postPage.entity.PostEntity;
import pl.phronimos.internship.postPage.service.PostService;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MainViewController {

    //public MainViewController() {
    //   clapsMap.put(1, 3);
    //    clapsMap.put(2, 10);
    //}

    @Autowired
    private PostService postService;
    //private final HashMap<Integer, Integer> clapsMap = new HashMap<>();

    // @ModelAttribute("clapsMap")
    //public Map<Integer, Integer> getClapsMap() {
    //    return clapsMap;
    //}


    @GetMapping(value = {"/mainView", "/"})
    public String mainView(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        model.addAttribute("commentDto", new CommentEntity());
        model.addAttribute("newPost", new PostEntity());
        return "mainView";
    }

    @PostMapping("/addComment")
    public String addComment(CommentEntity comment, @RequestParam int postId) {
        postService.addCommentToPost(postId, comment);
        return "redirect:/mainView?commentAdded";
    }

    @PostMapping("/addClap")
    public String addClaps(@RequestParam int postId){
//      Integer count = clapsMap.get(postId);
//      clapsMap.put(postId, ++count);
        postService.addClaps(postId);
        return "redirect:/mainView";
    }

    @PostMapping("/addPost")
    public String addPost(PostEntity post){
        postService.addPost(post);
        return "redirect:/mainView?postAdded";
    }
}
