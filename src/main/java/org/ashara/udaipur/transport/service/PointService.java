package org.ashara.udaipur.transport.service;

import org.ashara.udaipur.transport.beans.point.PointDto;
import org.ashara.udaipur.transport.beans.point.PointRequestDto;
import org.ashara.udaipur.transport.entities.Point;
import org.ashara.udaipur.transport.exceptions.ResourceNotFoundException;
import org.ashara.udaipur.transport.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PointService {

    @Autowired
    PointRepository pointRepository;

    @Transactional
    public PointDto create(PointRequestDto request) {
        Point point = new Point();
        PointDto response = new PointDto();

        point.setName(request.getName());
        point.setZonalHeadName(request.getZonalHeadName());
        point.setZonalHeadContactNo(request.getZonalHeadContactNo());
        point.setZonalHeadEmail(request.getZonalHeadEmail());
        point.setCreatedAt(LocalDateTime.now());
        point.setUpdatedAt(LocalDateTime.now());
        pointRepository.save(point);

        response.setPointId(point.getId());
        response.setName(point.getName());
        return response;
    }

    public PointDto details(Integer id) {
        PointDto response = new PointDto();
        Point vendor = pointRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Point Found"));

        response.setPointId(vendor.getId());
        response.setName(vendor.getName());
        response.setZonalHeadName(vendor.getZonalHeadName());
        response.setZonalHeadContactNo(vendor.getZonalHeadContactNo());
        response.setZonalHeadEmail(vendor.getZonalHeadEmail());
        return response;
    }

    public List<PointDto> allDetails() {
        return pointRepository.findAll().stream().map(point -> {
            PointDto dto = new PointDto();
            dto.setPointId(point.getId());
            dto.setName(point.getName());
            dto.setZonalHeadName(point.getZonalHeadName());
            dto.setZonalHeadContactNo(point.getZonalHeadContactNo());
            dto.setZonalHeadEmail(point.getZonalHeadEmail());
            return dto;
        }).collect(Collectors.toList());
    }
}
