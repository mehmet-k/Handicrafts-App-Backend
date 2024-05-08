package app.handicraft.service;

import app.handicraft.dto.createHandicraftType.CreateHandicraftTypeRequest;
import app.handicraft.model.handicraft.HandicraftType;
import app.handicraft.model.handicraft.HandicraftTypeView;
import app.handicraft.repository.HandicraftTypeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class HandicraftTypeService {

    private final HandicraftTypeRepository handicraftTypeRepository;

    public HandicraftTypeService(HandicraftTypeRepository handicraftTypeRepository) {
        this.handicraftTypeRepository = handicraftTypeRepository;
    }

    public HandicraftType addHandicraft(CreateHandicraftTypeRequest handicraftTypeRequest){
        if(handicraftTypeRequest == null){
            throw new RuntimeException("handicraftTypeRequest is null");
        }
        var handicraftType = new HandicraftType(handicraftTypeRequest.name(),handicraftTypeRequest.explanation());
        return handicraftTypeRepository.save(handicraftType);
    }
    public HandicraftType getHandicraftById(UUID id) {
        return handicraftTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("Handicraft type doesn't exists with this ID"));
    }

    public List<HandicraftType> getAllHandicraftTypes() {
        return handicraftTypeRepository.findAll();
    }

    public List<HandicraftTypeView> convertHandicraftTypesToViews(List<HandicraftType> handicraftTypes){
        List<HandicraftTypeView> handicraftTypeViewList = new ArrayList<>();
        for (HandicraftType h : handicraftTypes) {
            handicraftTypeViewList.add(new HandicraftTypeView(h.getId(), h.getName(), h.getName()));
        }
        return handicraftTypeViewList;
    }
    public List<HandicraftTypeView> getAllHandicraftTypeViews(List<HandicraftType> handicraftTypes) {
        return convertHandicraftTypesToViews(handicraftTypes);
    }

    public HandicraftTypeView convertHandicraftTypeToView(HandicraftType h){
        return new HandicraftTypeView(h.getId(), h.getName(), h.getExplanation());
    }

    public List<HandicraftType> getAllHandicraftTypesByIds(List<UUID> ids) {
        if(ids==null){
            throw new RuntimeException("ids is null");
        }
        List<HandicraftType> handicraftTypeList = new ArrayList<>();
        for(UUID id:ids){
            handicraftTypeList.add(handicraftTypeRepository.findById(id).orElseThrow(RuntimeException::new));
        }
        return handicraftTypeList;
    }



}