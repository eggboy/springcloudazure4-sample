package io.jaylee.sca4sample.controller;

import io.jaylee.sca4sample.service.BlobStorageService;
import io.jaylee.sca4sample.service.CacheForRedisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class SCA4TestController {

	private final BlobStorageService blobService;

	private final CacheForRedisService cacheForRedisService;

	public SCA4TestController(BlobStorageService blobService, CacheForRedisService cacheForRedisService) {
		this.blobService = blobService;
		this.cacheForRedisService = cacheForRedisService;
	}

	@GetMapping("/blob")
	public String blob() throws IOException {
		return blobService.listFilesInCSV();
	}

	@GetMapping("/redis/{value}")
	public String redis(@PathVariable String value) {
		return cacheForRedisService.testRedis(value);
	}

}
