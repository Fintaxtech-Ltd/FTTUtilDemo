# ftt-utils/AGENTS.md

Instructions for the main FTT utilities library module.

## Module Purpose

`ftt-utils` is the shared utilities library distributed as:

```xml
<dependency>
  <groupId>uk.co.fintaxtech</groupId>
  <artifactId>ftt-utils</artifactId>
  <version>0.0.2</version>
</dependency>
```

## Responsibilities

This module may contain:

- Date/time utilities
- String utilities
- Validation utilities
- Formatting utilities
- Number/currency utilities
- Collection utilities
- Lightweight Android-specific utilities only when clearly isolated
- Unit tests for every public method

This module must not contain:

- UI components
- Compose screens
- ViewModels
- Repositories
- Use cases
- Retrofit APIs
- Room databases
- DataStore implementations
- App-specific business logic
- Feature-specific domain models

## Package Organization

Prefer domain-specific packages, for example:

```text
uk.co.fintaxtech.utils
├── date
├── string
├── validation
├── formatter
├── number
├── collection
└── android
```

Avoid generic dumping-ground files/packages.

## Utility Design Rules

- Keep utilities small and focused.
- Prefer pure deterministic functions.
- Avoid hidden global state.
- Avoid static mutable state.
- Prefer explicit locale/timezone parameters if behavior depends on them.
- If a default locale/timezone is used, document it.
- Public API should be simple and stable.

## Testing Requirement

Every public method must be unit tested.

For each method, include tests for:

- standard valid input
- invalid input
- edge cases
- blank/null input if supported
- boundary values if numeric/date-based
- locale/timezone variation if relevant

## Documentation

Add KDoc to public utilities when behavior is not obvious.
