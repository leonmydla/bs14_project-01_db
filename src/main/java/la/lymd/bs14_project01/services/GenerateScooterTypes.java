package la.lymd.bs14_project01.services;

import com.google.common.collect.Lists;
import la.lymd.bs14_project01.entities.scooter.part.ScooterTypePart;
import la.lymd.bs14_project01.entities.scooter.part.ScooterTypePartRepository;
import la.lymd.bs14_project01.entities.scooter.type.ScooterType;
import la.lymd.bs14_project01.entities.scooter.type.ScooterTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenerateScooterTypes {

    private final ScooterTypeRepository typeRepo;
    private final ScooterTypePartRepository partRepo;

    public GenerateScooterTypes(
            ScooterTypeRepository typeRepository,
            ScooterTypePartRepository partRepository
    ) {
        this.typeRepo = typeRepository;
        this.partRepo = partRepository;
    }

    ScooterType generateScooterType(String name, List<String> parts) {
        ScooterType type = typeRepo.findOneByName(name);

        if (type == null) {
            type = new ScooterType();
            type.setName(name);
        }

        type.setParts(generateMissingParts(parts));
        return typeRepo.save(type);
    }

    private List<ScooterTypePart> generateMissingParts(List<String> parts) {
        List<ScooterTypePart> existingParts = Lists.newArrayList(partRepo.findAll())
                .stream()
                .filter(part -> parts.contains(part.getName()))
                .collect(Collectors.toList());

        List<String> existingPartsString = existingParts
                .stream()
                .map(ScooterTypePart::getName)
                .collect(Collectors.toList());

        List<ScooterTypePart> newParts = parts.stream()
                .filter(part -> !existingPartsString.contains(part))
                .map(part -> {
                    ScooterTypePart newPart = new ScooterTypePart();
                    newPart.setName(part);
                    partRepo.save(newPart);
                    return newPart;
                })
                .collect(Collectors.toList());

        existingParts.addAll(newParts);
        return existingParts;
    }
}
