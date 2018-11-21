package fr.wildcodeschool.githubtracker.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@Dependent
public class LoggerProducer {

    @Produces
    public Logger producer(InjectionPoint ip) {
        return LoggerFactory.getLogger(
                ip.getMember().getDeclaringClass().getName());
    }
}
