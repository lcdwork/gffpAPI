/**
 *    Auth:riozenc
 *    Date:2018年5月10日 上午10:29:32
 *    Title:cis.web.support.transaction.TransactionDAOSupport.java
 **/
package com.example.demo.transaction;

import com.riozenc.titanTool.spring.transaction.registry.TransactionDAORegistryPostProcessor;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransactionDAOSupport extends TransactionDAORegistryPostProcessor {

}
