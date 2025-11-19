package com.dbstraining.practice1.ServiceImpl;

import com.dbstraining.practice1.Model.Requests;
import com.dbstraining.practice1.Model.User;
import com.dbstraining.practice1.Repository.RequestRepository;
import com.dbstraining.practice1.Repository.UserRepository;
import com.dbstraining.practice1.Service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {

    private final RequestRepository requestRepository;
    private final UserRepository userRepository;

    @Override
    public Requests createRequest(Requests request, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        request.setUser(user);
        request.setCreatedAt(LocalDateTime.now());
        request.setUpdatedAt(LocalDateTime.now());
        return requestRepository.save(request);
    }

    @Override
    public Requests getRequestById(Long id) {
        return requestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Request not found"));
    }

    @Override
    public List<Requests> getAllRequests() {
        return requestRepository.findAll();
    }

    @Override
    public List<Requests> getRequestsByUser(Long userId) {
        return requestRepository.findByUserId(userId);
    }
}
