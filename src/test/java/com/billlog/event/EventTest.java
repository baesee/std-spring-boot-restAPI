package com.billlog.event;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EventTest {

    @Test
    public void builder(){
        String name = "인프런 레스트 api";
        Event event = Event.builder().name(name).description("디스크립션")
                .build();
        assertThat(event.getName()).isEqualTo(name);
        assertThat(event).isNotNull();
    }

    @Test
    public void javaBean(){

        //Given
        String name = "Event";
        String description = "Spring";

        //When
        Event event = new Event();
        event.setName(name);
        event.setDescription(description);

        // Then
        assertThat(event.getName()).isEqualTo(name);
        assertThat(event.getDescription()).isEqualTo(description);

    }


}