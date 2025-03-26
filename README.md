# JDK-24: Quantum-Resistant Cryptography in Java 24

This repository contains implementations and examples of quantum-resistant cryptographic algorithms introduced in Java 24, focusing on post-quantum cryptography to protect against future quantum computing attacks. The project includes code for the **Module-Lattice-Based Digital Signature Algorithm (ML-DSA)** (JEP 497) and can be extended to include the **Module-Lattice-Based Key-Encapsulation Mechanism (ML-KEM)** (JEP 496).

## Overview

Quantum computers pose a significant threat to traditional cryptographic algorithms like RSA and ECC, as they can efficiently solve problems such as integer factorization and discrete logarithms using Shor's algorithm. To address this, Java 24 introduces quantum-resistant algorithms standardized by NIST as part of its Post-Quantum Cryptography Standardization Project. This repository demonstrates how to use these algorithms in Java 24, with a focus on ML-DSA for digital signatures and potential extensions for ML-KEM for key encapsulation.

### Features
- **ML-DSA (JEP 497)**: A quantum-resistant digital signature algorithm based on the CRYSTALS-Dilithium algorithm, standardized by NIST (FIPS 204).
- **Future Support for ML-KEM (JEP 496)**: A quantum-resistant key encapsulation mechanism based on the CRYSTALS-Kyber algorithm, standardized by NIST (FIPS 203).
- Example code for signing and verifying messages using ML-DSA.
- Modular structure for easy extension to other quantum-resistant algorithms.

## Prerequisites

To run the code in this repository, you need the following:

- **Java 24**: ML-DSA and ML-KEM are introduced in Java 24 (released March 18, 2025). Download it from [Oracle](https://www.oracle.com/java/technologies/downloads/) or use a package manager like SDKMAN:
  ```bash
  sdk install java 24-open

By Sokpheng
