package com.sbaws.book.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat; //테스트검증 라이브러리의 검증메소드

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
