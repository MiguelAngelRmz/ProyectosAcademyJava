package com.springbatch.springbatch.springb;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.lang.NonNull;

import com.springbatch.springbatch.entity.Organization;

public class Processor implements ItemProcessor<Organization, Organization> {
    @Override
    public Organization process(@NonNull Organization organization) throws Exception {
        // Filtra organizaciones con más de 100 empleados
        if (organization.getEmployees() > 100) {
            return organization;
        }
        return null;
    }
}
