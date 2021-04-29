package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class TrelloMapperTest {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    void testMapToBoards() {
        //Given
        List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();
        List<TrelloListDto> trelloListDtoList = new ArrayList<>();

        trelloBoardDtoList.add(new TrelloBoardDto("1", "1 Board", trelloListDtoList));
        trelloListDtoList.add(new TrelloListDto("1", "1 List", true));

        //When
        List<TrelloBoard> resultTrelloBoards = trelloMapper.mapToBoards(trelloBoardDtoList);

        //Then
        assertEquals("1 Board", resultTrelloBoards.get(0).getName());
        assertEquals("1", resultTrelloBoards.get(0).getId());
        assertEquals(1, resultTrelloBoards.get(0).getLists().size());
    }

    @Test
    void testMapToBoardsDto() {
        //Given
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("1", "1 List", true));
        trelloBoards.add(new TrelloBoard("1", "1 Board", trelloLists));

        //When
        List<TrelloBoardDto> resultTrelloBoardDtos = trelloMapper.mapToBoardsDto(trelloBoards);

        //Then
        assertEquals("1 Board", resultTrelloBoardDtos.get(0).getName());
        assertEquals("1", resultTrelloBoardDtos.get(0).getId());
        assertEquals(1, resultTrelloBoardDtos.get(0).getLists().size());
    }

    @Test
    void testMapToList() {
        //Given
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(new TrelloListDto("2", "2 List", false));

        //When
        List<TrelloList> resultTrelloLists = trelloMapper.mapToList(trelloListDtos);

        //Then
        assertEquals("2 List", resultTrelloLists.get(0).getName());
        assertEquals("2", resultTrelloLists.get(0).getId());
        assertFalse(resultTrelloLists.get(0).isClosed());
    }

    @Test
    void testMapToListDto() {
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("2", "2 List", false));

        //When
        List<TrelloListDto> resultTrelloListDtos = trelloMapper.mapToListDto(trelloLists);

        //Then
        assertEquals("2 List", resultTrelloListDtos.get(0).getName());
        assertEquals("2", resultTrelloListDtos.get(0).getId());
        assertFalse(resultTrelloListDtos.get(0).isClosed());
    }

    @Test
    void testMapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("First Card", "test content", "top", "1");

        //When
        TrelloCardDto resultTrelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        //Then
        assertEquals("First Card", resultTrelloCardDto.getName());
        assertEquals("test content", resultTrelloCardDto.getDescription());
        assertEquals("top", resultTrelloCardDto.getPos());
        assertEquals("1", resultTrelloCardDto.getListId());
    }

    @Test
    void testMapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("First card", "test content", "top", "1");

        //When
        TrelloCard resultTrelloCard = trelloMapper.mapToCard(trelloCardDto);

        //Then
        assertEquals("First card", resultTrelloCard.getName());
        assertEquals("test content", resultTrelloCard.getDescription());
        assertEquals("top", resultTrelloCard.getPos());
        assertEquals("1", resultTrelloCard.getListId());
    }
}