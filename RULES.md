# RULES.md

Global hard rules for the FTT Utilities Library repository.

These rules have highest priority. If any AGENTS.md, SKILLS.md, generated code, or user request conflicts with this file, follow RULES.md.

---

## 1. Repository Scope

- This repository is for the Fintaxtech shared utilities library.
- The main publishable library module is `ftt-utils`.
- The `app` module is demo/sample/verification only.
- Do not add app-specific business logic to `ftt-utils`.
- Do not add UI components, Compose screens, ViewModels, repositories, Retrofit APIs, Room databases, or feature-specific code to `ftt-utils`.

---

## 2. Package & Publishing

- Published Maven coordinates:
  - `groupId = "uk.co.fintaxtech"`
  - `artifactId = "ftt-utils"`
- Keep public APIs stable and backwards-compatible where possible.
- Public API changes must be intentional and documented.
- Do not change package coordinates or artifact name unless explicitly requested.
- Do not hardcode secrets or GitHub package credentials.

---

## 3. Kotlin Utility Rules

- Kotlin only.
- Prefer small, focused utility classes/objects/functions.
- Every utility must solve a reusable cross-project problem.
- Do not create vague dumping-ground files like `Utils.kt`, `CommonUtils.kt`, or `Helper.kt`.
- Utility names must describe their domain:
  - `DateFormatter`
  - `EmailValidator`
  - `PhoneNumberFormatter`
  - `StringSanitizer`
  - `CurrencyFormatter`
- Prefer pure functions where possible.
- Avoid Android framework dependencies unless the utility is explicitly Android-specific.
- If Android dependency is required, isolate it in a clearly named Android-specific package.
- Do not use wildcard imports.
- Imports must be explicit and alphabetically sorted.
- Prefer `val` over `var`.
- Use minimal visibility: `private` or `internal` for non-public members.

---

## 4. API Design Rules

- Public methods must have clear names and predictable behavior.
- Public methods must avoid hidden side effects.
- Public methods should not throw unexpectedly unless documented.
- Prefer returning safe values for common invalid input where appropriate.
- If throwing is intentional, document and test it.
- Avoid nullable returns unless null is a meaningful API contract.
- Avoid overloading methods in a way that makes usage ambiguous.

---

## 5. Testing Rules

- **Every public method in every utility class/object must have unit tests.**
- Each method must have tests for:
  - normal/valid input
  - invalid or edge input
  - boundary cases where relevant
  - null/blank input where applicable
- Test file name must match the utility:
  - `DateFormatterTest`
  - `EmailValidatorTest`
  - `StringSanitizerTest`
- Test function names must use:
  `action_condition_expectedResult`
  Examples:
  - `formatDate_validMillis_returnsFormattedDate()`
  - `isEmailValid_invalidEmail_returnsFalse()`
  - `sanitize_blankInput_returnsEmptyString()`
- Do not use sentence-style or backtick test names.
- Use Arrange–Act–Assert.
- Use private `makeSUT()` only when constructing the system under test is non-trivial.
- Do not use `lateinit var sut` with `@Before`.
- No wildcard imports in tests.

---

## 6. Documentation Rules

- Public utilities should include KDoc when behavior is not obvious.
- Document:
  - expected input format
  - output format
  - failure/edge behavior
  - locale/timezone assumptions if relevant
- Keep documentation short and practical.

---

## 7. Output Rules for AI Agents

- Generate one file per code block.
- Each generated code block must start with:
  `// FILE: <relative path>`
- Exactly one `package` declaration per file.
- Do not combine unrelated utilities in one file.
- Do not mix app/demo code with library code in the same output block.
- For every generated utility file, generate a matching test file.
