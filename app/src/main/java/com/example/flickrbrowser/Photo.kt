package com.example.flickrbrowser

class Photo(val title: String, val author: String, val authorId: String,val links: String, val tags: String, val image: String) {
    override fun toString(): String {
        return "Photo(title='$title', author='$author', authorId='$authorId', links='$links', tags='$tags', image='$image')"
    }
}