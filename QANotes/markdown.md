## Learning to use Markdown

__Underscores make text italic__

**2 Asterisks make the text bold**

**_2 asterisks followed by an underscore does both_**

# Headers

# H1
## H2
### H3
#### H4
##### H5
###### H6 - Smallest

> Prefacing a line with a ">" creates a block quote for that line.

> Multiple line quotes
>
> Work like this.

* A single asterisk makes a bullet point
* For use in lists

1. Numbers to the same
2. For ordered lists.

* Indenting an asterisk **2 spaces**
  * Creates a nested bullet point.
    * Like this

Using **2 spaces** at the end of a line  
Is a "soft break", and creates a new line.  
Useful for writing paragraphs.

------------------------------------------------------------------------

# Links

## Inline Links

Wrap text in square brackets `[]`, then put the link in normal brackets `()`:

[Click this link](http://www.google.com)

## Reference Links

A reference link points to another place in the document, where the link is defined.  
This allows you to specify links somewhere in the document and reference them somewhere else, multiple times.  
Much like variables in programming.

**Syntax:**

Here's a link to [Google][google-link]
This is [GitHub][github-link]

[google-link]: http://www.google.com  
[github-link]: http://www.github.com

------------------------------------------------------------------------

# Images

Images work like links, but are prefaced with a `!`.  

## Inline Images

Inline images start with a `!`, with alt text in square brackets `[]`, and then the link in normal brackets `()`.  

My Next Car:
![alfa brera](https://d1ix0byejyn2u7.cloudfront.net/drive/images/made/drive/images/remote/https_f2.caranddriving.com/images/new/large/AlfaRomeoBrera0306(2)_794_529_70.jpg)

## Reference Images

This is the same syntax as reference links, but with the additional `!`.

![alfa brera alt text][alfa]

[alfa]: https://d1ix0byejyn2u7.cloudfront.net/drive/images/made/drive/images/remote/https_f2.caranddriving.com/images/new/large/AlfaRomeoBrera0306(2)_794_529_70.jpg  

## Aligning Images

### Left Align

Aligning images to the left works like this:  
```
<img align="left" width="150" height="100" src="https://d1ix0byejyn2u7.cloudfront.net/drive/images/made/drive/images/remote/https_f2.caranddriving.com/images/new/large/AlfaRomeoBrera0306(2)_794_529_70.jpg">
```  

<img align="left" width="150" height="100" src="https://d1ix0byejyn2u7.cloudfront.net/drive/images/made/drive/images/remote/https_f2.caranddriving.com/images/new/large/AlfaRomeoBrera0306(2)_794_529_70.jpg">  

------------------------------------------------------------------------

### Right Align

Right align works the same way, but with right:  
```
<img align="right" width="150" height="100" src="https://d1ix0byejyn2u7.cloudfront.net/drive/images/made/drive/images/remote/https_f2.caranddriving.com/images/new/large/AlfaRomeoBrera0306(2)_794_529_70.jpg">
```  

<img align="right" width="150" height="100" src="https://d1ix0byejyn2u7.cloudfront.net/drive/images/made/drive/images/remote/https_f2.caranddriving.com/images/new/large/AlfaRomeoBrera0306(2)_794_529_70.jpg">  

------------------------------------------------------------------------

### Center Align

Center is slightly different, using `<p>` tags:  
```
<p align="center">
<img width="150" height="100" src="https://d1ix0byejyn2u7.cloudfront.net/drive/images/made/drive/images/remote/https_f2.caranddriving.com/images/new/large/AlfaRomeoBrera0306(2)_794_529_70.jpg">
</p>
```  

<p align="center">
<img width="150" height="100" src="https://d1ix0byejyn2u7.cloudfront.net/drive/images/made/drive/images/remote/https_f2.caranddriving.com/images/new/large/AlfaRomeoBrera0306(2)_794_529_70.jpg">
</p>  

Height and width of images is also defined here.  

------------------------------------------------------------------------

# Collapse Sections

To add a collapsing section:  

```
<details>
<summary>Click to expand</summary>

## Header
Collapsed content
</details>  
```

<details>
<summary>Click to expand</summary>

## Collapsed content
* List item 1
  * List item 1a
  * List item 1b
* List item 2

```
System.out.Println("Some code");
```

</details>

------------------------------------------------------------------------

## Tables

3 or more hyphens creates a column's header, pipes ( | ) seperate each column.  
Pipes can also be added to either end of a table.  

```
| Column1    | Column 2    |
| ---------- | ----------- |
| Header     | Title       |
| Paragrah   | Text        |
```

| Column1    | Column 2    |
| ---------- | ----------- |
| Row 1      | Row 2       |
| Row 1      | Row 2       |

## Table Alignment

Adding a colon `:` to the hyphens in a header row aligns the text in that column. `:---` aligns left, `---:` aligns right, and `:---:` aligns center.  

```
| Left Align | Center Align | Right Align |
| :---       |    :---:     |        ---: |
| Row 1      | Row 1        | Row 1       |
| Row 2      | Row 2        | Row 2       |
```

| Left Align | Center Align | Right Align |
| :---       |    :---:     |        ---: |
| Row 1      | Row 1        | Row 1       |
| Row 2      | Row 2        | Row 2       |

------------------------------------------------------------------------
