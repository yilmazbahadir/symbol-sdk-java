# CHANGELOG
All notable changes to this project will be documented in this file.

The changelog format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/).

## [0.14.1] - 24-Oct-2019

**Milestone**: Fuschicho

- Improved Transaction serialization. Signature and signer are serialized when present.
- Upgraded Gradle to latest 5.6.3. Gradle build has been simplified.
- Removed JUnit 4 support. All the tests are now JUnit 5.
- Fixed hardcoded network type in unresolved address serialization.
- Improved release process.
- Other small fixes.

## [0.14.0] - 16-Oct-2019

**Milestone**: Fuschicho

- Applied latest OpenAPI doc (`v0.7.19`).
- Catbuffer binary Serialization and Deserialization for offline work.
- JSON Serialization and Deserialization for offline work.
- Created repository factories.
- Created new rest client repositories.
- Mosaic and address restrictions support
- Address, mosaic and namespace metadata support.
- Mosaic and address aliases support.
- Audit merkle proofs support.
- Improved integration tests.
- Replaced `UInt64DTO` for `BigInteger`.
- Open API generated libraries.
- Vertx and OkHttp rest client support.
- Improved Listeners.
- Other small fixes.

