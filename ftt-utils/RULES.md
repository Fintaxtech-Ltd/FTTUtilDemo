# ftt-utils/RULES.md (v0.0.2)
Priority: 1. Overrides all other docs.

## Scope & Module
- ftt-utils: Publishable library. NO UI, ViewModels, Repos, or Business Logic.
- app: Demo only. NO reusable logic here.
- Coordinates: uk.co.fintaxtech:ftt-utils:0.0.2

## Code Standards
- Kotlin 2.2.10. Pure functions, `val` over `var`.
- No vague names (Utils/Helper). Use Domain names (e.g. EmailValidator).
- **Naming Convention: All public utility classes/objects must be prefixed with `FTT` (e.g., `FTTVersionComparator`).**
- Visibility: Use `internal` for non-api members. No wildcard imports.
- Dependencies: Keep lean. Android deps ONLY in `.utils.android` package.

## API & Tests
- Stability: No breaking changes without request. Return safe defaults over exceptions.
- Testing: Mandatory 100% public API coverage (Happy/Edge/Null/Boundary).
- Test Pattern: Arrange-Act-Assert. Use `makeSUT()` factory, no `lateinit var sut`.
- Documentation: KDoc required for public members. Note Locale/TimeZone assumptions.

## AI Output
- Constraint: Always generate matching Test file with Utility file.
