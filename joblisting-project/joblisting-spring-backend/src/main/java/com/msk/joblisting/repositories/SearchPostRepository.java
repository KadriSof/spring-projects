package com.msk.joblisting.repositories;

import com.msk.joblisting.model.Post;

import java.util.List;

public interface SearchPostRepository{

    List<Post> searchByKeyWord(String query);
}
