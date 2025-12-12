package com.mproduits.configurations; 

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component                                  // <-- IMPORTANT : enregistre le bean
@ConfigurationProperties(prefix = "mes-configs")
public class ApplicationPropertiesConfiguration {
  private int limitDeProduits = 3;
  public int getLimitDeProduits() { return limitDeProduits; }
  public void setLimitDeProduits(int v) { this.limitDeProduits = v; }
}
