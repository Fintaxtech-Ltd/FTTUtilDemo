# AGENTS.md

AI agent instructions for the FTT Utilities Library repository.

## Project Summary

This repository contains shared utilities for Fintaxtech projects.

Known repository modules:

- `ftt-utils`: main publishable utilities library.
- `app`: demo/sample application module.
- `.github/workflows`: publishing and automation.

The package is published as:

```xml
<dependency>
  <groupId>uk.co.fintaxtech</groupId>
  <artifactId>ftt-utils</artifactId>
  <version>0.0.2</version>
</dependency>
```

## Required Reading Order

Before modifying code, read:

1. `/RULES.md`
2. The nearest module `AGENTS.md`
3. The nearest module `SKILLS.md`

## Instruction Precedence

If instructions conflict, follow this order:

1. `/RULES.md`
2. Nearest `AGENTS.md`
3. Nearest `SKILLS.md`
4. User request
5. Existing code style

## Architecture Direction

- `ftt-utils` contains reusable utilities only.
- Utilities should be small, focused, well-named, and heavily tested.
- `app` exists only to demonstrate or manually verify utility usage.
- Business/domain/data/UI architecture belongs in consumer apps, not this library.

## Agent Behavior

When asked to create or modify utility code:

- First identify whether the utility is truly reusable across projects.
- Place it in a domain-specific package, not a generic utils bucket.
- Keep APIs stable and predictable.
- Generate unit tests for every public method.
- Include edge cases and invalid input cases.
- Add KDoc for non-obvious behavior.
- Do not change publishing coordinates unless explicitly requested.

## Recommended Commands

Use these commands when relevant:

```bash
./gradlew :ftt-utils:test
./gradlew :ftt-utils:assembleRelease
./gradlew :app:assembleDebug
```

For release work, use the existing Gradle publishing/GitHub workflow configuration.
