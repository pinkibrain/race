package de.peter_neumaier.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import de.peter_neumaier.repository.RepositoryConfig;

@Configuration
@Import(RepositoryConfig.class)
public class ServiceConfig {

}
