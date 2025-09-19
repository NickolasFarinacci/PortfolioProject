# Portfolio Part 1: Component Brainstorming

- **Name**: Nick Farinacci
- **Dot Number**: Farinacci.30
- **Due Date**: 9/19/25 @12:40 PM

## Assignment Overview

The overall goal of the portfolio project is to have you design and implement
your own OSU component. There are no limits to what you choose to design and
implement, but your component must fit within the constraints of our software
sequence discipline. In other words, the component must extend from Standard and
must include both a kernel and a secondary interface.

Because this is a daunting project, we will be providing you with a series of
activities to aid in your design decisions. For example, the point of this
assignment is to help you brainstorm a few possible components and get some
feedback. For each of these components, you will need to specify the high-level
design in terms of the software sequence discipline. In other words, you will
describe a component, select a few kernel methods for your component, and select
a few secondary methods to layer on top of your kernel methods.

You are not required to specify contracts at this time. However, you are welcome
to be as detailed as you'd like. More detail means you will be able to get more
detailed feedback, which may help you decide which component to ultimately
implement.

## Assignment Checklist

To be sure you have completed everything on this assignment, we have littered
this document with TODO comments. You can browse all of them in VSCode by
opening the TODOs window from the sidebar. The icon looks like a tree and will
likely have a large number next to it indicating the number of TODOS. You'll
chip away at that number over the course of the semester. However, if you'd
like to remove this number, you can disable it by removing the following
line from the `settings.json` file:

```json
"todo-tree.general.showActivityBarBadge": true,
```

Which is not to be confused with the following setting that adds the counts
to the tree diagram (you may remove this one as well):

```json
"todo-tree.tree.showCountsInTree": true,
```

## Assignment Learning Objectives

Without learning objectives, there really is no clear reason why a particular
assessment or activity exists. Therefore, to be completely transparent, here is
what we're hoping you will learn through this particular aspect of the portfolio
project. Specifically, students should be able to:

1. Integrate their areas of interest in their personal lives and/or careers with
   their knowledge of software design
2. Determine the achievablility of a software design given time constraints
3. Design high-level software components following the software sequence
   discipline

## Assignment Rubric: 10 Points

Again, to be completely transparent, most of the portfolio project, except the
final submission, is designed as a formative assessment. Formative assessments
are meant to provide ongoing feedback in the learning process. Therefore,
the rubric is designed to assess the learning objectives *directly* in a way
that is low stakes—meaning you shouldn't have to worry about the grade. Just
do good work.

| Learning Objective                                                                                        | Subcategory                 | Weight | Missing                                                     | Beginning                                                                              | Developing                                                                                     | Meeting                                                                                 |
| --------------------------------------------------------------------------------------------------------- | --------------------------- | ------ | ----------------------------------------------------------- | -------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- |
| Students should be able to identify their values, interests, and/or goals as they relate to their designs | Metacognitive Memory        | 3      | (0) No attempt to summarize values, interests, and/or goals | (1) A brief description of values, interests, and/or goals is provided but lacks depth | (2) A description of values, interests, and/or goals is provided by are not related to designs | (3) A description of values, interests, and/or goals is provided and relates to designs |
| Students should be able to predict the feasibility of their designs                                       | Metacognitive Understanding | 3      | (0) No attempt to design components that are feasible       | (1) At least one component is feasible                                                 | (2) At least two components are feasible                                                       | (3) All three components are feasible                                                   |
| Students should be able to use the OSU discipline in all three designs                                    | Metacognitive Application   | 4      | (0) No attempt to follow the OSU discipline in designs      | (1) At least one design follows the OSU discipline                                     | (3) At least two designs follow the OSU discipline                                             | (4) All three designs follow the OSU discipline                                         |

Below is further rationale/explanation for the rubric items above:

1. Each design must align with your personal values and long-term
   goals. Because the goal of this project is to help your build out a
   portfolio, you really ought to care about what you're designing. We'll give
   you a chance to share your personal values, interests, and long-term goals
   below.
2. Each design must be achievable over the course of a single
   semester. Don't be afraid to design something very small. There is no shame
   in keeping it simple.
3. Each design must fit within the software sequence discipline. In
   other words, your design should expect to inherit from Standard, and it
   should contain both kernel and secondary methods. Also, null and aliasing
   must be avoided, when possible. The methods themselves must also be in
   justifiable locations, such as kernel or secondary.

## Pre-Assignment

> Before you jump in, we want you to take a moment to share your interests
> below. Use this space to talk about your career goals as well as your personal
> hobbies. These will help you clarify your values before you start
> brainstorming. Plus it helps us get to know you better! Feel free to share
> images in this section.

My main interests are video games, anime, working out, and music. I've played video games all throughout my childhood and is my main source of enjoyment in life. I've spent countless hours playing games with friends, relaxing on my own with an RPG or open-world adventure game, and even played competitively on my high school Esports team. Consequently, I wanted to be a CSE major so I could learn to develop my own video games in the future. Then, anime and music have just been more ways for me to relax from the stress of school. Finally, I've mostly used the gym as a way to keep active and feel more proud about my physical fitness. While I don't have as extreme results as most people I see do, going has made me feel positive about the progress I have made in my health.

## Assignment

As previously stated, you are tasked with brainstorming 3 possible components.
To aid you in this process, we have provided [some example components][example-components]
that may help you in your brainstorming. All of these components were made at
some point by one of your peers, so you should feel confident that you can
accomplish any of them.

There is no requirement that you use any of the components listed above.
If you want to model something else, go for it! Very common early object
projects usually attempt to model real-world systems like banks, cars,
etc. Make of this whatever seems interesting to you, and keep in mind that
you're just brainstorming right now. You do not have to commit to anything.

### Example Component

To help you brainstorm a few components, we've provided an example below of a
component you already know well: NaturalNumber. We highly recommend that you
mirror the formatting as close as possible in your designs. By following this
format, we can be more confident that your designs will be possible.

- Example Component: `NaturalNumber`
  - **Description**:
    - The purpose of this component is to model a non-negative
      integer. Our intent with this design was to keep a simple kernel that
      provides the minimum functionality needed to represent a natural number.
      Then, we provide more complex mathematical operations in the secondary
      interface.
  - **Kernel Methods**:
    - `void multiplyBy10(int k)`: multiplies `this` by 10 and adds `k`
    - `int divideBy10()`: divides `this` by 10 and reports the remainder
    - `boolean isZero()`: reports whether `this` is zero
  - **Secondary Methods**:
    - `void add(NaturalNumber n)`: adds `n` to `this`
    - `void subtract(NaturalNumber n)`: subtracts `n` from `this`
    - `void multiply(NaturalNumber n)`: multiplies `this` by `n`
    - `NaturalNumber divide(NaturalNumber n)`: divides `this` by `n`, returning
      the remainder
    - ...
  - **Additional Considerations** (*note*: "I don't know" is an acceptable
    answer for each of the following questions):
    - Would this component be mutable? Answer and explain:
      - Yes, basically all OSU components have to be mutable as long as they
        inherit from Standard. `clear`, `newInstance`, and `transferFrom` all
        mutate `this`.
    - Would this component rely on any internal classes (e.g., `Map.Pair`)?
      Answer and explain:
      - No. All methods work with integers or other NaturalNumbers.
    - Would this component need any enums or constants (e.g.,
      `Program.Instruction`)? Answer and explain:
      - Yes. NaturalNumber is base 10, and we track that in a constant called
          `RADIX`.
    - Can you implement your secondary methods using your kernel methods?
      Answer, explain, and give at least one example:
      - Yes. The kernel methods `multiplyBy10` and `divideBy10` can be used to
        manipulate our natural number as needed. For example, to implement
        `increment`, we can trim the last digit off with `divideBy10`, add 1 to
        it, verify that the digit hasn't overflown, and multiply the digit back.
        If the digit overflows, we reset it to zero and recursively call
        `increment`.

Keep in mind that the general idea when putting together these layered designs
is to put the minimal implementation in the kernel. In this case, the kernel is
only responsible for manipulating a digit at a time in the number. The secondary
methods use these manipulations to perform more complex operations like
adding two numbers together.

Also, keep in mind that we don't know the underlying implementation. It would be
completely reasonable to create a `NaturalNumber1L` class which layers the
kernel on top of the existing `BigInteger` class in Java. It would also be
reasonable to implement `NaturalNumber2` on top of `String` as seen in
Project 2. Do not worry about your implementations at this time.

On top of everything above, there is no expectation that you have a perfect
design. Part of the goal of this project is to have you actually use your
component once it's implemented to do something interesting. At which point, you
will likely refine your design to make your implementation easier to use.

### Component Designs

> Please use this section to share your designs.

- Component Design #1: Inventory
  - **Description**:
    - The purpose of the Inventory component is to contain miscellaneous values. The intent is to be like a library that stores different data types and allows you to extract them as need be. Then, with the proper space, the different variables held within the inventory can be manipulated. This could be in terms of removing or adding an item of a certain type or just tracking what items are currently contained.
  - **Kernel Methods**:
    - `void add(String item, int pos)`: Stores item in `this` at a given position
    - `String remove (String item)`: Takes `item` out of `this` and returns it
    - `int totalItems()`: reports the total number of `items` in `this`
  - **Secondary Methods**:
    - `boolean isEmpty()`: Checks to see if `this` is currently empty.
    - `boolean hasItem(String item)`: Checks to see if `this` contains a particular `item.`
    - `Set<String> uniqueItems()`: Returns a set that contains all of the unique entries within `this.`
  - **Additional Considerations** (*note*: "I don't know" is an acceptable
    answer for each of the following questions):
    - Would this component be mutable? Answer and explain:
      - Yes, this component would need to be mutable to contain multiple elements at different indexes.
    - Would this component rely on any internal classes (e.g., `Map.Pair`)?
      Answer and explain:
      - I think it would rely on the Map class in regards to using the key and value system to track how many of a particular item is in it.
    - Would this component need any enums or constants (e.g.,
      `Program.Instruction`)? Answer and explain:
      - It may need to define constants for the maximum number of an item that can be stored.
    - Can you implement your secondary methods using your kernel methods?
      Answer, explain, and give at least one example:
      - For the methods I have currently listed, I do not think you can use any of the kernal methods in the secondary methods.

- Component Design #2: Music Playlist
  - **Description**:
    - The purpose of the Music Playlist component is to contain names of songs to play in a particular order. The intent is to act as a way to track an order of songs to be played, then be able to rearrange them as one pleases. From there, the order can be changed as desired. An additional hope would be changing what song is next in the order and being able to estimate the time it would take for the playlist to loop.
  - **Kernel Methods**:
    - `void play(String songName)`: The `songName` is inserted into `this` and will begin playing.
    - `void addSong(String songName, int duration)`: The `songName` will be added to `this.` The variable `duration` will also be important later on for a secondary method.
    - `String removeSong(String songName)`: Removes `songName` from `this` and returns it to the user.
    - `String removeAnySong()`: Removes a random song and returns it.
    - `void insertSong(String songName, int pos)`: allows you to place `songName` anywhere in `this.`
    - `int songAt(String songName)`: returns the index of `songName` in `this.`
    - `void length()`: returns the number of songs in `this.`
  - **Secondary Methods**:
    - `void shuffle()`: `This` would be shuffled into a random order for the user.
    - `String totalDuration()`: Returns the time it would take for one to listen to every song in `this.` (Could be a String or int and either be in hours and minutes or just minutes).
    - `void playNext(int posOfSong)`: Moves the song at `posOfSong` and brings it to the 1st index of `this.`
  - **Additional Considerations** (*note*: "I don't know" is an acceptable
    answer for each of the following questions):
    - Would this component be mutable? Answer and explain:
      - The music playlist component would need to be mutable, since you will have to change songs, length, and order frequently.
    - Would this component rely on any internal classes (e.g., `Map.Pair`)?
      Answer and explain:
      - This component would primarily rely on either queue, as it would be very similar to an actual playlist, or use a map to keep track of songs and how long the song plays for.
    - Would this component need any enums or constants (e.g.,
      `Program.Instruction`)? Answer and explain:
      - I do not think that a music playlist would need any enums or constants since it should be able to contain as many songs as desired. If anything, I would say that a music playlist might be able to use enums to define different genres of music contained within the playlist.
    - Can you implement your secondary methods using your kernel methods?
      Answer, explain, and give at least one example:
      - Yes, specifically, you can use the methods removeAnySong, insertSong, removeSong, and songAt for the secondary methods shuffle and playNext.

- Component Design #3: Playable Character
  - **Description**:
    - The purpose of the Playable Character component is to model stats of different characters and be able to change them as necessary, similar to a character creation screen. The intent is to model different values to corresponding traits of a character, then provide goals for the player to achieve to improve upon the traits.
      interface.
  - **Kernel Methods**:
    - `void createChar(String name, String className)`: Use `name` and `className` to identify the character.
    - `void setHealth(int value)`: Set the health stat of the character. Other stats would also be implemented, such as strength, defense, and speed.
    - `void getExp()`: Returns `this.exp` value. Will be helpful for later methods.
  - **Secondary Methods**:
    - `void addExp(int amount)`: Method to augment the exp the character has so stats can increase. Adds `amount` to `this.exp.`
    - `boolean canLevelUp()`: method that checks if `this.exp` has passed a threshold to increase their characters stats.
    - `void levelUp()`: Allows the character to level up, increasing their stats as a result.
    - `void damageCalc(int damage)`: Lowers the players health count by `damage.` Other checks can then be implemented to see if the health has dropped to 0 to act as a "game over."
  - **Additional Considerations** (*note*: "I don't know" is an acceptable
    answer for each of the following questions):
    - Would this component be mutable? Answer and explain:
      - This component would be mutable because the values for the different stats and experience must be altered throughout the growth of the playable character.
    - Would this component rely on any internal classes (e.g., `Map.Pair`)?
      Answer and explain:
      - I can see this component relying on naturalNumbers for tracking stat values and determining whether or not the health has reached zero. I can also see the use of map in storing the information for each stat corresponding to a character.
    - Would this component need any enums or constants (e.g.,
      `Program.Instruction`)? Answer and explain:
      - This component would use constants for variables like an exp threshold, if it will be static for each level, health max and mins, and stat caps.
    - Can you implement your secondary methods using your kernel methods?
      Answer, explain, and give at least one example:
      - You can utilize "get" methods in secondary methods, such as using getExp in addExp. You need to know if the character currently has any exp and add it to the amount given in the "addExp" method.

## Post-Assignment

The following sections detail everything that you should do once you've
completed the assignment.

### Changelog

At the end of every assignment, you should update the
[CHANGELOG.md](../../CHANGELOG.md) file found in the root of the project folder.
Since this is likely the first time you've done this, we would recommend
browsing the existing file. It includes all of the changes made to the portfolio
project template. When you're ready, you should delete this file and start your
own. Here's what I would expect to see at the minimum:

```markdown
# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## YYYY.MM.DD

### Added

- Designed a <!-- insert name of component 1 here --> component
- Designed a <!-- insert name of component 2 here --> component
- Designed a <!-- insert name of component 3 here --> component
```

Here `YYYY.MM.DD` would be the date of your submission, such as 2024.04.21.

You may notice that things are nicely linked in the root CHANGELOG. If you'd
like to accomplish that, you will need to make GitHub releases after each pull
request merge (or at least tag your commits). This is not required.

In the future, the CHANGELOG will be used to document changes in your
designs, so we can gauge your progress. Please keep it updated at each stage
of development.

### Submission

If you have completed the assignment using this template, we recommend that
you convert it to a PDF before submission. If you're not sure how, check out
this [Markdown to PDF guide][markdown-to-pdf-guide]. However, PDFs should be
created for you automatically every time you save, so just double check that
all your work is there before submitting. For future assignments, you will
just be submitting a link to a pull request. This will be the only time
you have to submit any PDFs.

<!-- TODO: upload a PDF of this document and the CHANGELOG to Carmen then delete this comment -->

### Peer Review

Following the completion of this assignment, you will be assigned three
students' component brainstorming assignments for review. Your job during the
peer review process is to help your peers flesh out their designs. Specifically,
you should be helping them determine which of their designs would be most
practical to complete this semester. When reviewing your peers' assignments,
please treat them with respect. Note also that we can see your comments, which
could help your case if you're looking to become a grader. Ultimately, we
recommend using the following feedback rubric to ensure that your feedback is
both helpful and respectful (you may want to render the markdown as HTML or a
PDF to read this rubric as a table).

| Criteria of Constructive Feedback | Missing                                                                                                                           | Developing                                                                                                                                                                                                                                | Meeting                                                                                                                                                               |
| --------------------------------- | --------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Specific                          | All feedback is general (not specific)                                                                                            | Some (but not all) feedback is specific and some examples may be provided.                                                                                                                                                                | All feedback is specific, with examples provided where possible                                                                                                       |
| Actionable                        | None of the feedback provides actionable items or suggestions for improvement                                                     | Some feedback provides suggestions for improvement, while some do not                                                                                                                                                                     | All (or nearly all) feedback is actionable; most criticisms are followed by suggestions for improvement                                                               |
| Prioritized                       | Feedback provides only major or minor concerns, but not both. Major and minar concerns are not labeled or feedback is unorganized | Feedback provides both major and minor concerns, but it is not clear which is which and/or the feedback is not as well organized as it could be                                                                                           | Feedback clearly labels major and minor concerns. Feedback is organized in a way that allows the reader to easily understand which points to prioritize in a revision |
| Balanced                          | Feedback describes either strengths or areas of improvement, but not both                                                         | Feedback describes both strengths and areas for improvement, but it is more heavily weighted towards one or the other, and/or descusses both but does not clearly identify which part of the feedback is a strength/area for improvement  | Feedback provides balanced discussion of the document's strengths and areas for improvement. It is clear which piece of feedback is which                             |
| Tactful                           | Overall tone and language are not appropriate (e.g., not considerate, could be interpreted as personal criticism or attack)       | Overall feedback tone and language are general positive, tactul, and non-threatening, but one or more feedback comments could be interpretted as not tactful and/or feedback leans toward personal criticism, not focused on the document | Feedback tone and language are positive, tactful, and non-threatening. Feedback addesses the document, not the writer                                                 |

### Assignment Feedback

If you'd like to give feedback for this assignment (or any assignment, really),
make use of [this survey][survey]. Your feedback helps make assignments
better for future students.

<!-- TODO: follow the link to share your feedback then delete this comment -->

[example-components]: https://therenegadecoder.com/code/the-never-ending-list-of-small-programming-project-ideas/
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
[survey]: https://forms.gle/dumXHo6A4Enucdkq9
