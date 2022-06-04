package com.sbaws.book.springboot.service.posts;

import com.sbaws.book.springboot.domain.posts.Posts;
import com.sbaws.book.springboot.domain.posts.PostsRepository;
import com.sbaws.book.springboot.web.dto.PostsListResponseDto;
import com.sbaws.book.springboot.web.dto.PostsResponseDto;
import com.sbaws.book.springboot.web.dto.PostsSaveRequestDto;
import com.sbaws.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor //final이 선언된 모든 필드를 인자값으로 하는 생성자를 추가
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){ //jpa의 영속성 컨텍스트때문에 DB에 쿼리를 날리지 않아도 됨
        //영속성 컨텍스트 : 엔티티를 영구 저장하는 환경
        //jpa의 핵심내용은 엔티티가 영속성 컨텍스트에 포함여부로 갈림 _ 더티체킹 개념 확인!!!
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        return new PostsResponseDto(entity);
    }

    //트랜잭션 어노테이션에 (readonly=true)를 주면 트랜잭션 범위는 유지, 조회기능만 남겨두어 조회 속도가 개선됨
    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new) //람다식 사용 = .map(posts -> new PostsListResponseDto(posts))
                //postsRepository 결과로 넘어온 Posts의 Stream을 map을 통해 PostsListResponseDto 변환 -> List로 반환하는 메소드
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        Posts posts  = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        postsRepository.delete(posts);
    }
}
