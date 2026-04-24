# ftt-utils/SKILLS.md

Skills for the FTT utilities library module.

---

## Skill: Create Utility

Use when adding a reusable utility to `ftt-utils`.

### Inputs

```markdown
utility = "EmailValidator"       # Utility name
package_area = "validation"      # date, string, validation, formatter, number, collection, android
```

### Generate

- Utility file:
  - `ftt-utils/src/main/java/.../${package_area}/${utility}.kt`
- Matching test file:
  - `ftt-utils/src/test/java/.../${package_area}/${utility}Test.kt`

### Rules

- Utility must be reusable across projects.
- Do not create vague files like `Utils.kt` or `Helper.kt`.
- Prefer object or top-level functions only when appropriate.
- Prefer pure functions.
- Do not introduce Android dependencies unless `package_area = "android"`.
- Add KDoc when behavior is not obvious.
- No wildcard imports.
- Imports sorted alphabetically.

### Test Rules

- Every public method must have unit tests.
- Test names must use `action_condition_expectedResult`.
- Include:
  - valid input
  - invalid input
  - edge cases
  - boundary cases where relevant
- Use Arrange–Act–Assert.
- Do not use backtick sentence test names.

### Output Format

- One file per code block.
- Start with:
  `// FILE: ftt-utils/src/main/java/.../<Utility>.kt`
- Then output matching test file:
  `// FILE: ftt-utils/src/test/java/.../<Utility>Test.kt`

---

## Skill: Add Tests for Existing Utility

Use when an existing utility has missing or weak tests.

### Steps

1. Inspect all public methods in the utility.
2. Create or update the matching `<Utility>Test.kt`.
3. Add at least one test for every public method.
4. Add edge case tests for each method.
5. Preserve existing tests unless they are incorrect.

### Required Coverage

For every public method:

- valid input test
- invalid/edge input test
- boundary test if relevant
- exception test if method is expected to throw

### Naming

Use:

```kotlin
method_condition_expectedResult()
```

Examples:

```kotlin
isEmailValid_validEmail_returnsTrue()
isEmailValid_missingAtSymbol_returnsFalse()
formatMillis_zeroMillis_returnsEpochDate()
```

---

## Skill: Refactor Utility

Use when improving an existing utility API or implementation.

### Rules

- Preserve public API unless explicitly asked to break it.
- If public API changes, provide migration notes.
- Keep behavior covered by tests.
- Add tests before or with refactor.
- Remove duplication.
- Avoid over-generalizing.

---

## Skill: Create Date/Time Utility

Use when adding date/time helpers.

### Rules

- Clearly document timezone and locale behavior.
- Prefer explicit `Locale` and `ZoneId`/timezone parameters where applicable.
- Do not rely on device defaults silently unless documented.
- Test multiple boundary values:
  - epoch
  - current-like sample date
  - leap year if relevant
  - invalid input if supported

---

## Skill: Create Validation Utility

Use when adding validators such as email, phone, postcode, URL.

### Rules

- Return Boolean for simple validators.
- Do not throw for normal invalid input unless explicitly required.
- Test valid, invalid, blank, and edge inputs.
- Keep regex readable and documented when complex.

---

## Skill: Prepare Utilities Release

Use when preparing a new Maven package version.

### Checklist

- Update version in publishing config.
- Confirm artifact coordinates remain:
  - `uk.co.fintaxtech:ftt-utils`
- Run:
  - `./gradlew :ftt-utils:test`
  - `./gradlew :ftt-utils:assembleRelease`
- Confirm demo app builds:
  - `./gradlew :app:assembleDebug`
- Update README if public APIs changed.
- Add changelog notes.
