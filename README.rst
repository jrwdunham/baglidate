================================================================================
  Baglidate: a validator for BagIt bags
================================================================================

The ``baglidate`` library validates BagIt bags using the "in development"
`BagIt 1.0 spec`_. For the most up-to-date spec, see the `bagit1.0 branch of
the BagIt GitHub page`_.

All this repo really does is compare the non-normative ABNF grammars in section
7 of the `BagIt 1.0 spec`_ to the prose descriptions and examples provided in
other areas of that text. It uses the `Clojure Instaparse library` to create
parsers from the supplied BagIt ABNF grammars and compares them against example
inputs (BagIt files) that are expected to be valid. If errors are discovered, a
new grammar is written (suffixed with ``_fixed``) which accepts the example
inputs.


Usage
================================================================================

Assuming you have Clojure >= 1.8 installed, run the tests as you develop::

    $ lein test-refresh

Or, just run the tests once::

    $ lein test

You should see something like::

    Ran 5 tests containing 10 assertions.
    0 failures, 0 errors.


Directory Structure
================================================================================

The ABNF grammars are in files with the ``.abnf`` extension under
``resources/``. Files with the ``_fixed`` suffix are attempts to improve on
the otherwise identically named files (which are copied directly from the
`BagIt 1.0 spec`_)::

    ├── resources
    │   ├── bag_declaration.abnf
    │   ├── bag_metadata.abnf
    │   ├── bag_metadata_fixed.abnf
    │   ├── fetch_file.abnf
    │   ├── fetch_file_fixed.abnf
    │   ├── payload_manifest.abnf
    │   ├── payload_manifest_fixed.abnf
    │   └── uri.abnf

The resources/ directory also contains example input files that are assumed to
be valid. These are used in the tests::

    ├── resources
    │   ├── sample-bag-info.txt
    │   ├── sample-fetch-file.txt
    │   ├── sample-manifest-sha256.txt

The logic for reading the grammars and input files, using Instaparse to create
parsers from the grammars, and testing the inputs against the parsers is in the
sole files in the src/ and test/ directories::

    ├── src
    │   └── bagit_instaparse
    │       └── core.clj
    └── test
        └── bagit_instaparse
            └── core_test.clj


References
================================================================================

- `The instaparse docs for ABNF`_
- `The Wikipedia article on ABNF`_
- `The URI ABNF`_
- `Unicode in ABNF (experimental)`_



License
================================================================================

Copyright © 2018 Joel Dunham

Distributed under the Eclipse Public License version 1.0.


.. _`The URI ABNF`: https://tools.ietf.org/html/rfc3986#appendix-A
.. _`BagIt 1.0 spec`: http://gwdev-justinlittman.wrlc.org/bagit.html
.. _`The5Wikipedia article on ABNF`: https://en.wikipedia.org/wiki/Augmented_Backus%E2%80%93Naur_form
.. _`bagit1.0 branch of the BagIt GitHub page`: https://github.com/LibraryOfCongress/bagit-spec/tree/bagit1.0
.. _`The instaparse docs for ABNF`: https://github.com/Engelberg/instaparse/blob/master/docs/ABNF.md
.. _`The Wikipedia article on ABNF`: https://en.wikipedia.org/wiki/Augmented_Backus%E2%80%93Naur_form
.. _`Unicode in ABNF (experimental)`: https://tools.ietf.org/html/draft-seantek-unicode-in-abnf-03
.. _`Clojure Instaparse library`: https://github.com/Engelberg/instaparse
