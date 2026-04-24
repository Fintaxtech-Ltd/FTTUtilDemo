# ftt-utils/SKILLS.md
Implementation workflows.

## Skill: Utility Creation/Refactor
1. Locate domain package (e.g., `date`).
2. Implement pure logic in `src/main`.
3. Implement matching tests in `src/test` (naming: `action_condition_result`).
4. Add KDoc with @param and @return.
5. If Refactoring: Maintain signature; provide "Migration Note" if API changes.

## Skill: Validation & Formatting
- Validation: Return `Boolean`. No exceptions for bad input. Comment Regex.
- Formatting: Require explicit `Locale`/`ZoneId` where possible.

## Skill: Release Prep
1. Bump version in build config.
2. Run full verification suite (test + assemble).
3. Update CHANGELOG.md.