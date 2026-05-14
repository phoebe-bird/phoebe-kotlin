# Changelog

## 0.1.0-alpha.3 (2026-05-14)

Full Changelog: [v0.1.0-alpha.2...v0.1.0-alpha.3](https://github.com/phoebe-bird/phoebe-kotlin/compare/v0.1.0-alpha.2...v0.1.0-alpha.3)

### ⚠ BREAKING CHANGES

* **client:** change precision of some numeric types
* **client:** extract auto pagination to shared classes
* **client:** **Migration:** - If you were referencing the `AutoPager` class on a specific `*Page` or `*PageAsync` type, then you should instead reference the shared `AutoPager` and `AutoPagerAsync` types, under the `core` package
    - If you were referencing `getNextPage` or `getNextPageParams`:
       - Swap to `nextPage()` and `nextPageParams()`
       - Note that these both now return non-nullable types (use `hasNextPage()` before calling these, since they will throw if it's impossible to get another page)

### Features

* **api:** manual updates ([971e215](https://github.com/phoebe-bird/phoebe-kotlin/commit/971e215fc72cd2bd22694fc965e33177692d9336))
* **client:** add `{QueryParams,Headers}#put(String, JsonValue)` methods ([f2dd4e8](https://github.com/phoebe-bird/phoebe-kotlin/commit/f2dd4e85b178a469dadfd25dc33b2f307a08d7d4))
* **client:** add `HttpRequest#url()` method ([6553cd1](https://github.com/phoebe-bird/phoebe-kotlin/commit/6553cd1d8b460857649f3453ba547d25d5ff1b79))
* **client:** add a `withOptions` method ([7114ce5](https://github.com/phoebe-bird/phoebe-kotlin/commit/7114ce5d1de4541d7f9e0de0f234130cb1198582))
* **client:** add https config options ([5ef8239](https://github.com/phoebe-bird/phoebe-kotlin/commit/5ef8239b83502cb0fc72ca6c55b9931bc031ddcf))
* **client:** allow configuring dispatcher executor service ([2649e17](https://github.com/phoebe-bird/phoebe-kotlin/commit/2649e171296822354692529a9d391b3ed234657c))
* **client:** allow configuring env via system properties ([4501add](https://github.com/phoebe-bird/phoebe-kotlin/commit/4501adde390256db7e37b2158f85c0216d257388))
* **client:** allow providing some params positionally ([b0dec3e](https://github.com/phoebe-bird/phoebe-kotlin/commit/b0dec3e065105e05eb34f0bdfba82616c60b7f95))
* **client:** extract auto pagination to shared classes ([93d50ea](https://github.com/phoebe-bird/phoebe-kotlin/commit/93d50eaae30f63a0619bcc2476e54b9558afffe1))
* **client:** implement per-endpoint base URL support ([e1386d4](https://github.com/phoebe-bird/phoebe-kotlin/commit/e1386d437f5dc0a4c3876b05cd15a82ad46194d8))
* **client:** send `X-Stainless-Kotlin-Version` header ([65877f5](https://github.com/phoebe-bird/phoebe-kotlin/commit/65877f5096ae328724260d72ac432cd820025ebd))
* initial stlc build ([b8b74b5](https://github.com/phoebe-bird/phoebe-kotlin/commit/b8b74b5a29367df380a26ae2fba1d33a96e4c261))


### Bug Fixes

* **client:** bump max requests per host to max requests (5 -&gt; 64) ([6be3ad1](https://github.com/phoebe-bird/phoebe-kotlin/commit/6be3ad1086141a3ad50ea0a9736c66b3f1dd044e))
* **client:** disallow coercion from float to int ([a4d96a3](https://github.com/phoebe-bird/phoebe-kotlin/commit/a4d96a36101a3351409d96d6594dc8fc98223de7))
* **client:** don't close client on `withOptions` usage when original is gc'd ([e85929b](https://github.com/phoebe-bird/phoebe-kotlin/commit/e85929b3feb4b8f106331d370e898df497544dde))
* **client:** ensure error handling always occurs ([77be9a2](https://github.com/phoebe-bird/phoebe-kotlin/commit/77be9a21f7329f0a27da53272964ad3f457a89d2))
* **client:** fully respect max retries ([01386ad](https://github.com/phoebe-bird/phoebe-kotlin/commit/01386ad8aac6fc20113a8fe537c9148f8c6f49b1))
* **client:** preserve time zone in lenient date-time parsing ([f8d27dc](https://github.com/phoebe-bird/phoebe-kotlin/commit/f8d27dc94ab392b0b7714ab96d5021c42194a25a))
* **client:** send retry count header for max retries 0 ([01386ad](https://github.com/phoebe-bird/phoebe-kotlin/commit/01386ad8aac6fc20113a8fe537c9148f8c6f49b1))
* date time deserialization leniency ([486e6bc](https://github.com/phoebe-bird/phoebe-kotlin/commit/486e6bcb6b259c30069c9f3842a79d765003f942))


### Chores

* **ci:** enable for pull requests ([263ceaf](https://github.com/phoebe-bird/phoebe-kotlin/commit/263ceafe941d05a1542fa2326c8e3043028b6428))
* **ci:** only run for pushes and fork pull requests ([b56a624](https://github.com/phoebe-bird/phoebe-kotlin/commit/b56a62437b2d4c7d1598c51394bbf58b2f877d42))
* **ci:** upgrade `actions/setup-java` ([b105324](https://github.com/phoebe-bird/phoebe-kotlin/commit/b105324e74605d462c3fcfaa7928b360fd0cd8b4))
* configure new SDK language ([ba8008d](https://github.com/phoebe-bird/phoebe-kotlin/commit/ba8008d1cd8ca339bf4ada9cfeb3c932f870ee72))
* **docs:** grammar improvements ([731b78d](https://github.com/phoebe-bird/phoebe-kotlin/commit/731b78dd2344f0c87e1a5df955e76e78eb106913))
* enable release-please ([32dec2d](https://github.com/phoebe-bird/phoebe-kotlin/commit/32dec2df05f1e94efa0aa8e557847af262595970))
* **internal:** allow running specific example from cli ([1f2ec0f](https://github.com/phoebe-bird/phoebe-kotlin/commit/1f2ec0f32cb24cea3905f7d5d885a4b7a9c8b194))
* **internal:** codegen related update ([362fd09](https://github.com/phoebe-bird/phoebe-kotlin/commit/362fd098aa8958c597cc10239ab743c5f74d2af6))
* **internal:** codegen related update ([73cb7f0](https://github.com/phoebe-bird/phoebe-kotlin/commit/73cb7f0b76ca3742a762e921a78e8e3b9b9fa6e3))
* **internal:** codegen related update ([0c673bc](https://github.com/phoebe-bird/phoebe-kotlin/commit/0c673bc540cd651e80c2b18c33fd1df9aecf8f71))
* **internal:** codegen related update ([29241a5](https://github.com/phoebe-bird/phoebe-kotlin/commit/29241a5d76f323b0acd12684744a1bc7c8c810e0))
* **internal:** codegen related update ([cbbeed5](https://github.com/phoebe-bird/phoebe-kotlin/commit/cbbeed5bce5ba457903728ba9c5de01f60e532ba))
* **internal:** codegen related update ([c263c2a](https://github.com/phoebe-bird/phoebe-kotlin/commit/c263c2a8f8bb942bca1bc960d5371c5c732fc0df))
* **internal:** codegen related update ([057c6d8](https://github.com/phoebe-bird/phoebe-kotlin/commit/057c6d8b7309334a0098abb157f5d7f87bb3b922))
* **internal:** codegen related update ([de47ba7](https://github.com/phoebe-bird/phoebe-kotlin/commit/de47ba717b9d3f3899f818f4c332ef7e383be65f))
* **internal:** codegen related update ([7fd1ef8](https://github.com/phoebe-bird/phoebe-kotlin/commit/7fd1ef8f02ac16caf852a3f02b4c1c8b54b4e4fc))
* **internal:** codegen related update ([35e2bfc](https://github.com/phoebe-bird/phoebe-kotlin/commit/35e2bfcb48d766aad7308a57b0d8e2a033431b2f))
* **internal:** codegen related update ([9da0bcc](https://github.com/phoebe-bird/phoebe-kotlin/commit/9da0bcc40b3d919b89be8efb46a8df47aa5fd2be))
* **internal:** codegen related update ([1e985b1](https://github.com/phoebe-bird/phoebe-kotlin/commit/1e985b1e1fe464955aa912b3dc3631331fdef597))
* **internal:** codegen related update ([895cf4c](https://github.com/phoebe-bird/phoebe-kotlin/commit/895cf4c8f95bb1ef3f6ee2fc004b31283fa527bd))
* **internal:** codegen related update ([80cd6ea](https://github.com/phoebe-bird/phoebe-kotlin/commit/80cd6ea24c0bfa8d2b3ba13f7c687e6a1dff9ec7))
* **internal:** codegen related update ([c9db965](https://github.com/phoebe-bird/phoebe-kotlin/commit/c9db965f32a53ffc4afe4b5b10d26d2b4212282e))
* **internal:** codegen related update ([e357b01](https://github.com/phoebe-bird/phoebe-kotlin/commit/e357b014f4cfae63c80da5ebb7874c2e05bfc8d2))
* **internal:** codegen related update ([e386be0](https://github.com/phoebe-bird/phoebe-kotlin/commit/e386be0ec0b6dc4f01b0c5e903369b5c5ec9dd0c))
* **internal:** codegen related update ([fdb43a8](https://github.com/phoebe-bird/phoebe-kotlin/commit/fdb43a88e129f23a5398a1616f1e5f32bcf5f57b))
* **internal:** codegen related update ([7f4225e](https://github.com/phoebe-bird/phoebe-kotlin/commit/7f4225e439e197244c651fa35a5aa0a8ca5e1eb7))
* **internal:** codegen related update ([167ec69](https://github.com/phoebe-bird/phoebe-kotlin/commit/167ec690115e0491ff22262976266cb717e269d0))
* **internal:** codegen related update ([6a608e8](https://github.com/phoebe-bird/phoebe-kotlin/commit/6a608e8678a3fba1521fedaf92c4cf9f864d77a3))
* **internal:** codegen related update ([5ff7fa1](https://github.com/phoebe-bird/phoebe-kotlin/commit/5ff7fa187a1d03d7af14d24f4e6ec3d39380bfc0))
* **internal:** codegen related update ([771e920](https://github.com/phoebe-bird/phoebe-kotlin/commit/771e92055206f2f1e3c960cef9ad2f82e080aaaa))
* **internal:** codegen related update ([4c64c99](https://github.com/phoebe-bird/phoebe-kotlin/commit/4c64c992d3d8e8fcdb66dd0e552f51e6c5970042))
* **internal:** codegen related update ([81c0b1f](https://github.com/phoebe-bird/phoebe-kotlin/commit/81c0b1fec7d8d6bd387d6ef6fc525e17c3c7fd39))
* **internal:** codegen related update ([84f64cf](https://github.com/phoebe-bird/phoebe-kotlin/commit/84f64cfaeb1e5467f94dc60413f412426f6daf65))
* **internal:** codegen related update ([78957df](https://github.com/phoebe-bird/phoebe-kotlin/commit/78957dfa35e58f84b94f5d5eea8dc0812244d5e9))
* **internal:** codegen related update ([708897b](https://github.com/phoebe-bird/phoebe-kotlin/commit/708897bb625c47a1817f7b8bde3e9ff0a31fb09d))
* **internal:** codegen related update ([38db728](https://github.com/phoebe-bird/phoebe-kotlin/commit/38db728e9f4dbe61af5e17ec87ba6cc57c6890c2))
* **internal:** codegen related update ([66edd77](https://github.com/phoebe-bird/phoebe-kotlin/commit/66edd7778c41c38329b6a6d7a827fa0c3b36fdd1))
* **internal:** codegen related update ([75c76b4](https://github.com/phoebe-bird/phoebe-kotlin/commit/75c76b4c7b5ad5a0d8374f7b8d3f7b4c7244b564))
* **internal:** codegen related update ([f0eb619](https://github.com/phoebe-bird/phoebe-kotlin/commit/f0eb6194c9062a395c872fed310ca435648a32fc))
* **internal:** correct cache invalidation for `SKIP_MOCK_TESTS` ([bd30e9b](https://github.com/phoebe-bird/phoebe-kotlin/commit/bd30e9b7a55bd0f75939b862d247de362b0a6828))
* **internal:** depend on packages directly in example ([01386ad](https://github.com/phoebe-bird/phoebe-kotlin/commit/01386ad8aac6fc20113a8fe537c9148f8c6f49b1))
* **internal:** refactor build files to support future stainless package uploads ([2967815](https://github.com/phoebe-bird/phoebe-kotlin/commit/296781591f9c89a1e8dccff392e030196e1f362b))
* **internal:** refactor delegating from client to options ([4c3b713](https://github.com/phoebe-bird/phoebe-kotlin/commit/4c3b7131f03e339bcee8d94e9ee317f8207e5ca6))
* **internal:** remove unnecessary `[...]` in `[@see](https://github.com/see)` ([cfebf52](https://github.com/phoebe-bird/phoebe-kotlin/commit/cfebf52f942a52b6ef23b1571a4889b3f7755518))
* **internal:** update `actions/checkout` version ([08fffdd](https://github.com/phoebe-bird/phoebe-kotlin/commit/08fffdd3e4aa054ea6ac134516912d337a950b64))
* regenerate from phoebe-config[#2](https://github.com/phoebe-bird/phoebe-kotlin/issues/2) ([6f0b1a1](https://github.com/phoebe-bird/phoebe-kotlin/commit/6f0b1a1f9056ebe182a0bd0de12035fa2da6061a))
* test on Jackson 2.14.0 to avoid encountering FasterXML/jackson-databind[#3240](https://github.com/phoebe-bird/phoebe-kotlin/issues/3240) in tests ([486e6bc](https://github.com/phoebe-bird/phoebe-kotlin/commit/486e6bcb6b259c30069c9f3842a79d765003f942))


### Documentation

* fix missing readme comment ([d874960](https://github.com/phoebe-bird/phoebe-kotlin/commit/d874960c53a7eb32adbdef8e2baafde1f6c64a51))
* more code comments ([c21d081](https://github.com/phoebe-bird/phoebe-kotlin/commit/c21d0811e972c93e6d8836fcc6489f658601085a))
* prominently feature MCP server setup in root SDK readmes ([a1fff66](https://github.com/phoebe-bird/phoebe-kotlin/commit/a1fff664d9857f0d128c74c9cddec63f64dd95e1))
* remove `$` for better copy-pasteabality ([f85fd9e](https://github.com/phoebe-bird/phoebe-kotlin/commit/f85fd9e4131d6ba1a7ffc2f13c4b9ac2fb36a309))


### Refactors

* **client:** change precision of some numeric types ([13a3e03](https://github.com/phoebe-bird/phoebe-kotlin/commit/13a3e030b2eebb825bc5fd6f7e8e2c836b748cba))
* **internal:** minor `ClientOptionsTest` change ([d4a490d](https://github.com/phoebe-bird/phoebe-kotlin/commit/d4a490defffefa18b912b18b88c1958af56c58a1))

## [0.1.0-alpha.2](https://github.com/phoebe-bird/phoebe-kotlin/compare/v0.1.0-alpha.1...v0.1.0-alpha.2) (2026-05-14)


### Features

* initial stlc build ([b8b74b5](https://github.com/phoebe-bird/phoebe-kotlin/commit/b8b74b5a29367df380a26ae2fba1d33a96e4c261))


### Chores

* enable release-please ([32dec2d](https://github.com/phoebe-bird/phoebe-kotlin/commit/32dec2df05f1e94efa0aa8e557847af262595970))
* regenerate from phoebe-config[#2](https://github.com/phoebe-bird/phoebe-kotlin/issues/2) ([6f0b1a1](https://github.com/phoebe-bird/phoebe-kotlin/commit/6f0b1a1f9056ebe182a0bd0de12035fa2da6061a))
* regenerate SDKs from phoebe-config[#2](https://github.com/phoebe-bird/phoebe-kotlin/issues/2) (feat: bump openapi info.version to 1.0.2 (Phase 9 dry run [#2](https://github.com/phoebe-bird/phoebe-kotlin/issues/2))) ([3d42c1b](https://github.com/phoebe-bird/phoebe-kotlin/commit/3d42c1b6076611a5973df466711c33475f5b5832))

## 0.1.0-alpha.1 (2026-05-13)

Full Changelog: [v0.0.1-alpha.0...v0.1.0-alpha.1](https://github.com/phoebe-bird/phoebe-kotlin/compare/v0.0.1-alpha.0...v0.1.0-alpha.1)

### ⚠ BREAKING CHANGES

* **client:** change precision of some numeric types
* **client:** extract auto pagination to shared classes
* **client:** **Migration:** - If you were referencing the `AutoPager` class on a specific `*Page` or `*PageAsync` type, then you should instead reference the shared `AutoPager` and `AutoPagerAsync` types, under the `core` package
    - If you were referencing `getNextPage` or `getNextPageParams`:
       - Swap to `nextPage()` and `nextPageParams()`
       - Note that these both now return non-nullable types (use `hasNextPage()` before calling these, since they will throw if it's impossible to get another page)

### Features

* **api:** manual updates ([971e215](https://github.com/phoebe-bird/phoebe-kotlin/commit/971e215fc72cd2bd22694fc965e33177692d9336))
* **client:** add `{QueryParams,Headers}#put(String, JsonValue)` methods ([f2dd4e8](https://github.com/phoebe-bird/phoebe-kotlin/commit/f2dd4e85b178a469dadfd25dc33b2f307a08d7d4))
* **client:** add `HttpRequest#url()` method ([6553cd1](https://github.com/phoebe-bird/phoebe-kotlin/commit/6553cd1d8b460857649f3453ba547d25d5ff1b79))
* **client:** add a `withOptions` method ([7114ce5](https://github.com/phoebe-bird/phoebe-kotlin/commit/7114ce5d1de4541d7f9e0de0f234130cb1198582))
* **client:** add https config options ([5ef8239](https://github.com/phoebe-bird/phoebe-kotlin/commit/5ef8239b83502cb0fc72ca6c55b9931bc031ddcf))
* **client:** allow configuring dispatcher executor service ([2649e17](https://github.com/phoebe-bird/phoebe-kotlin/commit/2649e171296822354692529a9d391b3ed234657c))
* **client:** allow configuring env via system properties ([4501add](https://github.com/phoebe-bird/phoebe-kotlin/commit/4501adde390256db7e37b2158f85c0216d257388))
* **client:** allow providing some params positionally ([b0dec3e](https://github.com/phoebe-bird/phoebe-kotlin/commit/b0dec3e065105e05eb34f0bdfba82616c60b7f95))
* **client:** extract auto pagination to shared classes ([93d50ea](https://github.com/phoebe-bird/phoebe-kotlin/commit/93d50eaae30f63a0619bcc2476e54b9558afffe1))
* **client:** implement per-endpoint base URL support ([e1386d4](https://github.com/phoebe-bird/phoebe-kotlin/commit/e1386d437f5dc0a4c3876b05cd15a82ad46194d8))
* **client:** send `X-Stainless-Kotlin-Version` header ([65877f5](https://github.com/phoebe-bird/phoebe-kotlin/commit/65877f5096ae328724260d72ac432cd820025ebd))


### Bug Fixes

* **client:** bump max requests per host to max requests (5 -&gt; 64) ([6be3ad1](https://github.com/phoebe-bird/phoebe-kotlin/commit/6be3ad1086141a3ad50ea0a9736c66b3f1dd044e))
* **client:** disallow coercion from float to int ([a4d96a3](https://github.com/phoebe-bird/phoebe-kotlin/commit/a4d96a36101a3351409d96d6594dc8fc98223de7))
* **client:** don't close client on `withOptions` usage when original is gc'd ([e85929b](https://github.com/phoebe-bird/phoebe-kotlin/commit/e85929b3feb4b8f106331d370e898df497544dde))
* **client:** ensure error handling always occurs ([77be9a2](https://github.com/phoebe-bird/phoebe-kotlin/commit/77be9a21f7329f0a27da53272964ad3f457a89d2))
* **client:** fully respect max retries ([01386ad](https://github.com/phoebe-bird/phoebe-kotlin/commit/01386ad8aac6fc20113a8fe537c9148f8c6f49b1))
* **client:** preserve time zone in lenient date-time parsing ([f8d27dc](https://github.com/phoebe-bird/phoebe-kotlin/commit/f8d27dc94ab392b0b7714ab96d5021c42194a25a))
* **client:** send retry count header for max retries 0 ([01386ad](https://github.com/phoebe-bird/phoebe-kotlin/commit/01386ad8aac6fc20113a8fe537c9148f8c6f49b1))
* date time deserialization leniency ([486e6bc](https://github.com/phoebe-bird/phoebe-kotlin/commit/486e6bcb6b259c30069c9f3842a79d765003f942))


### Chores

* **ci:** enable for pull requests ([263ceaf](https://github.com/phoebe-bird/phoebe-kotlin/commit/263ceafe941d05a1542fa2326c8e3043028b6428))
* **ci:** only run for pushes and fork pull requests ([b56a624](https://github.com/phoebe-bird/phoebe-kotlin/commit/b56a62437b2d4c7d1598c51394bbf58b2f877d42))
* **ci:** upgrade `actions/setup-java` ([b105324](https://github.com/phoebe-bird/phoebe-kotlin/commit/b105324e74605d462c3fcfaa7928b360fd0cd8b4))
* configure new SDK language ([ba8008d](https://github.com/phoebe-bird/phoebe-kotlin/commit/ba8008d1cd8ca339bf4ada9cfeb3c932f870ee72))
* **docs:** grammar improvements ([731b78d](https://github.com/phoebe-bird/phoebe-kotlin/commit/731b78dd2344f0c87e1a5df955e76e78eb106913))
* **internal:** allow running specific example from cli ([1f2ec0f](https://github.com/phoebe-bird/phoebe-kotlin/commit/1f2ec0f32cb24cea3905f7d5d885a4b7a9c8b194))
* **internal:** codegen related update ([362fd09](https://github.com/phoebe-bird/phoebe-kotlin/commit/362fd098aa8958c597cc10239ab743c5f74d2af6))
* **internal:** codegen related update ([73cb7f0](https://github.com/phoebe-bird/phoebe-kotlin/commit/73cb7f0b76ca3742a762e921a78e8e3b9b9fa6e3))
* **internal:** codegen related update ([0c673bc](https://github.com/phoebe-bird/phoebe-kotlin/commit/0c673bc540cd651e80c2b18c33fd1df9aecf8f71))
* **internal:** codegen related update ([29241a5](https://github.com/phoebe-bird/phoebe-kotlin/commit/29241a5d76f323b0acd12684744a1bc7c8c810e0))
* **internal:** codegen related update ([cbbeed5](https://github.com/phoebe-bird/phoebe-kotlin/commit/cbbeed5bce5ba457903728ba9c5de01f60e532ba))
* **internal:** codegen related update ([c263c2a](https://github.com/phoebe-bird/phoebe-kotlin/commit/c263c2a8f8bb942bca1bc960d5371c5c732fc0df))
* **internal:** codegen related update ([057c6d8](https://github.com/phoebe-bird/phoebe-kotlin/commit/057c6d8b7309334a0098abb157f5d7f87bb3b922))
* **internal:** codegen related update ([de47ba7](https://github.com/phoebe-bird/phoebe-kotlin/commit/de47ba717b9d3f3899f818f4c332ef7e383be65f))
* **internal:** codegen related update ([7fd1ef8](https://github.com/phoebe-bird/phoebe-kotlin/commit/7fd1ef8f02ac16caf852a3f02b4c1c8b54b4e4fc))
* **internal:** codegen related update ([35e2bfc](https://github.com/phoebe-bird/phoebe-kotlin/commit/35e2bfcb48d766aad7308a57b0d8e2a033431b2f))
* **internal:** codegen related update ([9da0bcc](https://github.com/phoebe-bird/phoebe-kotlin/commit/9da0bcc40b3d919b89be8efb46a8df47aa5fd2be))
* **internal:** codegen related update ([1e985b1](https://github.com/phoebe-bird/phoebe-kotlin/commit/1e985b1e1fe464955aa912b3dc3631331fdef597))
* **internal:** codegen related update ([895cf4c](https://github.com/phoebe-bird/phoebe-kotlin/commit/895cf4c8f95bb1ef3f6ee2fc004b31283fa527bd))
* **internal:** codegen related update ([80cd6ea](https://github.com/phoebe-bird/phoebe-kotlin/commit/80cd6ea24c0bfa8d2b3ba13f7c687e6a1dff9ec7))
* **internal:** codegen related update ([c9db965](https://github.com/phoebe-bird/phoebe-kotlin/commit/c9db965f32a53ffc4afe4b5b10d26d2b4212282e))
* **internal:** codegen related update ([e357b01](https://github.com/phoebe-bird/phoebe-kotlin/commit/e357b014f4cfae63c80da5ebb7874c2e05bfc8d2))
* **internal:** codegen related update ([e386be0](https://github.com/phoebe-bird/phoebe-kotlin/commit/e386be0ec0b6dc4f01b0c5e903369b5c5ec9dd0c))
* **internal:** codegen related update ([fdb43a8](https://github.com/phoebe-bird/phoebe-kotlin/commit/fdb43a88e129f23a5398a1616f1e5f32bcf5f57b))
* **internal:** codegen related update ([7f4225e](https://github.com/phoebe-bird/phoebe-kotlin/commit/7f4225e439e197244c651fa35a5aa0a8ca5e1eb7))
* **internal:** codegen related update ([167ec69](https://github.com/phoebe-bird/phoebe-kotlin/commit/167ec690115e0491ff22262976266cb717e269d0))
* **internal:** codegen related update ([6a608e8](https://github.com/phoebe-bird/phoebe-kotlin/commit/6a608e8678a3fba1521fedaf92c4cf9f864d77a3))
* **internal:** codegen related update ([5ff7fa1](https://github.com/phoebe-bird/phoebe-kotlin/commit/5ff7fa187a1d03d7af14d24f4e6ec3d39380bfc0))
* **internal:** codegen related update ([771e920](https://github.com/phoebe-bird/phoebe-kotlin/commit/771e92055206f2f1e3c960cef9ad2f82e080aaaa))
* **internal:** codegen related update ([4c64c99](https://github.com/phoebe-bird/phoebe-kotlin/commit/4c64c992d3d8e8fcdb66dd0e552f51e6c5970042))
* **internal:** codegen related update ([81c0b1f](https://github.com/phoebe-bird/phoebe-kotlin/commit/81c0b1fec7d8d6bd387d6ef6fc525e17c3c7fd39))
* **internal:** codegen related update ([84f64cf](https://github.com/phoebe-bird/phoebe-kotlin/commit/84f64cfaeb1e5467f94dc60413f412426f6daf65))
* **internal:** codegen related update ([78957df](https://github.com/phoebe-bird/phoebe-kotlin/commit/78957dfa35e58f84b94f5d5eea8dc0812244d5e9))
* **internal:** codegen related update ([708897b](https://github.com/phoebe-bird/phoebe-kotlin/commit/708897bb625c47a1817f7b8bde3e9ff0a31fb09d))
* **internal:** codegen related update ([38db728](https://github.com/phoebe-bird/phoebe-kotlin/commit/38db728e9f4dbe61af5e17ec87ba6cc57c6890c2))
* **internal:** codegen related update ([66edd77](https://github.com/phoebe-bird/phoebe-kotlin/commit/66edd7778c41c38329b6a6d7a827fa0c3b36fdd1))
* **internal:** codegen related update ([75c76b4](https://github.com/phoebe-bird/phoebe-kotlin/commit/75c76b4c7b5ad5a0d8374f7b8d3f7b4c7244b564))
* **internal:** codegen related update ([f0eb619](https://github.com/phoebe-bird/phoebe-kotlin/commit/f0eb6194c9062a395c872fed310ca435648a32fc))
* **internal:** correct cache invalidation for `SKIP_MOCK_TESTS` ([bd30e9b](https://github.com/phoebe-bird/phoebe-kotlin/commit/bd30e9b7a55bd0f75939b862d247de362b0a6828))
* **internal:** depend on packages directly in example ([01386ad](https://github.com/phoebe-bird/phoebe-kotlin/commit/01386ad8aac6fc20113a8fe537c9148f8c6f49b1))
* **internal:** refactor build files to support future stainless package uploads ([2967815](https://github.com/phoebe-bird/phoebe-kotlin/commit/296781591f9c89a1e8dccff392e030196e1f362b))
* **internal:** refactor delegating from client to options ([4c3b713](https://github.com/phoebe-bird/phoebe-kotlin/commit/4c3b7131f03e339bcee8d94e9ee317f8207e5ca6))
* **internal:** remove unnecessary `[...]` in `[@see](https://github.com/see)` ([cfebf52](https://github.com/phoebe-bird/phoebe-kotlin/commit/cfebf52f942a52b6ef23b1571a4889b3f7755518))
* **internal:** update `actions/checkout` version ([08fffdd](https://github.com/phoebe-bird/phoebe-kotlin/commit/08fffdd3e4aa054ea6ac134516912d337a950b64))
* test on Jackson 2.14.0 to avoid encountering FasterXML/jackson-databind[#3240](https://github.com/phoebe-bird/phoebe-kotlin/issues/3240) in tests ([486e6bc](https://github.com/phoebe-bird/phoebe-kotlin/commit/486e6bcb6b259c30069c9f3842a79d765003f942))


### Documentation

* fix missing readme comment ([d874960](https://github.com/phoebe-bird/phoebe-kotlin/commit/d874960c53a7eb32adbdef8e2baafde1f6c64a51))
* more code comments ([c21d081](https://github.com/phoebe-bird/phoebe-kotlin/commit/c21d0811e972c93e6d8836fcc6489f658601085a))
* prominently feature MCP server setup in root SDK readmes ([a1fff66](https://github.com/phoebe-bird/phoebe-kotlin/commit/a1fff664d9857f0d128c74c9cddec63f64dd95e1))
* remove `$` for better copy-pasteabality ([f85fd9e](https://github.com/phoebe-bird/phoebe-kotlin/commit/f85fd9e4131d6ba1a7ffc2f13c4b9ac2fb36a309))


### Refactors

* **client:** change precision of some numeric types ([13a3e03](https://github.com/phoebe-bird/phoebe-kotlin/commit/13a3e030b2eebb825bc5fd6f7e8e2c836b748cba))
* **internal:** minor `ClientOptionsTest` change ([d4a490d](https://github.com/phoebe-bird/phoebe-kotlin/commit/d4a490defffefa18b912b18b88c1958af56c58a1))
