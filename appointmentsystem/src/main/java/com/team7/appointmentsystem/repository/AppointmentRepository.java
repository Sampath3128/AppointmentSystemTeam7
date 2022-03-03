package com.team7.appointmentsystem.repository;

import com.team7.appointmentsystem.entity.Appointment;
import com.team7.appointmentsystem.miscellinious.AppointmentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByBusinessBusinessid(long businessId);

    Optional<List<AppointmentDetails>> findByUsersUserid(long userid);

    List<Appointment> findByBusinessBusinessidAndAppointmentDate(long businessId, Date date1);
}
