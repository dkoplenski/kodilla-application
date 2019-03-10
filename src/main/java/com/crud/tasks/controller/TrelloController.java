package com.crud.tasks.controller;

import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    @Autowired
    private TrelloClient trelloClient;

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public void getTrelloBoards() {
        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();
        trelloBoards.stream()
                .filter(board -> board.getId()!=null && board.getName() != null)
                .filter(board -> board.getName().contains("Kodilla"))
                .collect(Collectors.toList())
                .forEach(trelloBoardDto -> {
                    System.out.println("ID: " + trelloBoardDto.getId()
                            + "\nBOARD NAME: " + trelloBoardDto.getName()
                            + "\nURL: " + trelloBoardDto.getUrl());
                    System.out.println("The board contains lists: ");
                    trelloBoardDto.getTrelloLists().forEach(trelloList ->
                            System.out.println("   ->NAME: " + trelloList.getName() +
                                               "\n     ID: " + trelloList.getId()));
                });
    }
}