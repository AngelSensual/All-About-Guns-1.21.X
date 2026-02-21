# Project TODO List

| Task | File(s) | Details |
|------|---------|---------|
| Verify Jar Artifact Contents | `build.gradle`, `src/main/resources` | Audit `build.gradle` and resource directories to ensure only necessary files (assets, data, compiled classes) are included in the final mod .jar, excluding source files or dev assets. |
| Refactor Project Directory Structure | `src/`, `LibEdit/` | Reorganize the source code and library directories (e.g., `src/` and `LibEdit/`) to follow standard Fabric/Gradle project conventions for better maintainability and separation of concerns. |
| Select Gun Item Model Style (2D vs 3D) | `src/main/resources/assets/all-about-guns/models/item/` | Decide whether gun items in the hotbar/inventory should use 2D sprites (like standard items) or 3D models. This affects model JSONs and texture requirements. |
| Optimize Creative Tab Organization | `src/main/java/com/angelsensual/abg/item/ModItemGroups.java` (assumed) | Reorganize items in the creative menu. Evaluate different organization methods (e.g., grouping by type, tier, or utility) to determine which looks and functions best for the user. |
| Pin AngelS-Core-Lib Version | `build.gradle` | Change the dependency to use an explicit version tag (e.g., `v1.0.0` or specific commit hash) of AngelS-Core-Lib for 1.21 instead of `master-SNAPSHOT` before pushing the final release. |
