# AGENTS.md - Mutation Testing Lab Guide

## Project Overview
This is a **mutation testing laboratory** using **PIT (Pitest)** to measure test effectiveness. The project contains a simple `CalculatorService` with basic arithmetic operations and corresponding unit tests. The primary goal is to evaluate how well tests catch bugs injected via mutations.

## Architecture & Key Components

### Core Components
- **`CalculatorService.java`** (`src/main/java/org/jugistanbul/`): Service with 4 arithmetic methods (add, sub, div, mul) that use primitive double operations
- **`CalculatorServiceTest.java`** (`src/test/java/org/jugistanbul/`): JUnit test suite with 4 test methods validating each operation
- **PIT Reports** (`target/pit-reports/`): HTML mutation testing reports showing mutation kill/survive metrics

### Build & Test Workflow
- **Build Tool**: Maven (pom.xml)
- **Test Framework**: JUnit 4/5 (mixed imports - `@Test` from junit.Test, assertions from jupiter)
- **Mutation Testing**: PIT Maven plugin generates mutation coverage reports
- **Build Command**: `mvn clean compile test org.pitest:pitest-maven:mutationCoverage` (see `run.sh`)

## Critical Workflows & Commands

### Standard Build & Test Cycle
```bash
# Run full mutation testing pipeline (PIT mutation analysis + test execution)
bash run.sh
# OR manually:
mvn clean compile test org.pitest:pitest-maven:mutationCoverage
```

### Accessing Results
- **Mutation Report**: Open `target/pit-reports/index.html` in browser
- **Class-Level Details**: `target/pit-reports/org.jugistanbul/CalculatorService.java.html`
- **Surefire Reports**: `target/surefire-reports/`

### Key Test Assertions Pattern
Tests use tolerance-based assertions (`assertEquals(expected, actual, 0.001)`) for floating-point comparisons due to Double precision handling.

## Code Patterns & Conventions

### Test Structure
- **Instantiation Pattern**: Service instantiated fresh in each test method (no reuse/fixtures)
- **Test Method Naming**: `test<Operation>()` format (testAdd, testSubtract, etc.)
- **Operation Coverage**: Each of 4 arithmetic methods has exactly 1 test method

### Service Implementation Notes
- **Data Type Inconsistency**: `add()` returns `Double` (wrapper), other methods return `double` (primitive) - relevant for mutation testing
- **Import Unused**: `BigDecimal` imported but never used (potential technical debt)
- **Division**: No zero-check; `div()` will throw arithmetic exception on divide-by-zero

## Integration Points & Dependencies

### Maven Dependencies (via pom.xml - access restricted)
- JUnit for testing (mixed versions)
- PIT for mutation testing analysis

### Mutation Kill Metrics (Current State)
- **Line Coverage**: 100% (5/5 lines)
- **Mutation Coverage**: 100% (8/8 mutations killed)
- **Test Strength**: 100% (all mutations caught by tests)

## For AI Agents: Critical Considerations

When modifying code or tests:
1. **Mutation Testing Context**: Changes affect mutation kill rates; verify via `bash run.sh`
2. **Floating-Point Math**: Always use tolerance assertions (delta = 0.001) for Double comparisons
3. **Type Consistency**: Consider impact of `Double` vs `double` return types on mutation analysis
4. **Test Coverage**: New methods must have corresponding tests to maintain 100% mutation coverage
5. **Report Interpretation**: PIT doesn't just measure line coverage—it measures *effective* tests by checking if mutations are detected

## Common Development Tasks

- **Add New Arithmetic Method**: Add method to `CalculatorService`, create test in `CalculatorServiceTest`, run `bash run.sh` to verify mutation kill
- **Fix Test Failures**: Check `target/surefire-reports/TEST-*.xml` for details
- **Inspect Mutation Details**: Open specific class report at `target/pit-reports/org.jugistanbul/CalculatorService.java.html`

