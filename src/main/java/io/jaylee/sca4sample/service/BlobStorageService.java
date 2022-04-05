package io.jaylee.sca4sample.service;

import com.azure.spring.cloud.core.resource.AzureStorageBlobProtocolResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@Slf4j
public class BlobStorageService {

	@Value("${spring.cloud.azure.storage.blob.container-name}")
	String containerName;

	private final AzureStorageBlobProtocolResolver azureStorageBlobProtocolResolver;

	public BlobStorageService(AzureStorageBlobProtocolResolver azureStorageBlobProtocolResolver) {
		this.azureStorageBlobProtocolResolver = azureStorageBlobProtocolResolver;
	}

	public String listFilesInCSV() throws IOException {
		log.info("containerName : " + containerName);
		var resources = azureStorageBlobProtocolResolver.getResources("azure-blob://" + containerName + "/*");

		return Stream.of(resources).map(Resource::getFilename).collect(Collectors.joining(","));
	}

}
