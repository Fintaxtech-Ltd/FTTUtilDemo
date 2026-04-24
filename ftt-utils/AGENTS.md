# ftt-utils/AGENTS.md
Context for AI working on Fintaxtech Utilities.

## Hierarchy
1. RULES.md | 2. AGENTS.md | 3. SKILLS.md

## Responsibilities
- Library: uk.co.fintaxtech.utils.[date|string|validation|formatter|number|collection|android]
- Stability: Keep public APIs deterministic and stateless.
- Verification:
    - `./gradlew :ftt-utils:test` (Unit tests)
    - `./gradlew :ftt-utils:assembleRelease` (Build AAR)
    - `./gradlew :app:assembleDebug` (Demo check)

## Behavior
- Prioritize safety: Handle empty strings, nulls, and numeric boundaries.
- Precision: Explicitly handle UTC vs System Default in date logic.