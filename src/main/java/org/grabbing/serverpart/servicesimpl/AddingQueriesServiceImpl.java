package org.grabbing.serverpart.servicesimpl;

import lombok.RequiredArgsConstructor;
import org.grabbing.serverpart.repositories.AccountRepository;
import org.grabbing.serverpart.repositories.QueryItselfRepository;
import org.grabbing.serverpart.repositories.ResponseItselfRepository;
import org.grabbing.serverpart.services.AddingQueriesService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddingQueriesServiceImpl implements AddingQueriesService {
    private final QueryItselfRepository queryItselfRepository;
    private final ResponseItselfRepository responseItselfRepository;

    @Override
    public void addTest(String url, long faceId) {
        queryItselfRepository.createTest(url, faceId);
    }

    @Override
    public List<String> getTest(long faceId) {
        List<String> result = new ArrayList<>();

        List<Long> list = queryItselfRepository.getByFaceIdTest(faceId);
        for (Long i : list) {
            String item = queryItselfRepository.getUrlByIdTest(i);
            item += ": \n ";
            if (queryItselfRepository.getResponseIdTest(i) == 0) {
                item += "in progress";
            } else {
                item += responseItselfRepository.getBodyByIdTest(queryItselfRepository.getResponseIdTest(i));
            }

            result.add(item);
        }

        return result;
    }
}
